package com.trucare.claims.service;


import com.trucare.claims.kafka.ClaimProducerService;
import com.trucare.claims.mapper.ClaimMapper;
import com.trucare.claims.model.Claim;
import com.trucare.claims.repository.ClaimRepository;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import com.trucare.shared.client.MemberClient;
import com.trucare.shared.client.ProviderClient;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimProducerService claimProducerService;
    private final ClaimMapper claimMapper;
    private final MemberClient memberClient;
    private final ProviderClient providerClient;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository, ClaimProducerService claimProducerService, KafkaTemplate kafkaTemplate, ClaimMapper claimMapper, MemberClient memberClient, ProviderClient providerClient) {
        this.claimRepository = claimRepository;
        this.claimProducerService = claimProducerService;
        this.claimMapper = claimMapper;
        this.memberClient = memberClient;
        this.providerClient = providerClient;
    }

    // Create or update claim reactively
    @Override
    public ClaimDTO createClaim(CreateClaimDTO createClaimDTO) {

        // Validate Member and Provider using Feign Clients
        boolean isMemberValid = memberClient.validateMember(createClaimDTO.getMemberId());
        boolean isProviderValid = providerClient.validateProvider(createClaimDTO.getProviderId());

        if (!isMemberValid || !isProviderValid) {
            throw new ValidationException("Invalid member or provider");
        }

        // Save Claim with Pending Status
        Claim claim = claimMapper.toClaim(createClaimDTO);
        claim.setClaimStatus("PENDING_DOCUMENTS");
        Claim savedClaim = claimRepository.save(claim);

        // Publish Document Upload Event
        kafkaTemplate.send("document.upload", new DocumentUploadEvent(savedClaim.getId(), createClaimDTO.getDocuments()));

        // Return Claim DTO
        return claimMapper.toClaimDTO(savedClaim);
    }
}
