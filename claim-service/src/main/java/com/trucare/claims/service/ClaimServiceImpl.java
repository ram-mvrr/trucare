package com.trucare.claims.service;


import com.trucare.claims.kafka.ClaimProducerService;
import com.trucare.claims.mapper.ClaimMapper;
import com.trucare.claims.model.Claim;
import com.trucare.claims.repository.ClaimRepository;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimProducerService claimProducerService;
    private final ClaimMapper claimMapper;

    @Autowired
    public ClaimServiceImpl(ClaimRepository claimRepository, ClaimProducerService claimProducerService, KafkaTemplate kafkaTemplate, ClaimMapper claimMapper) {
        this.claimRepository = claimRepository;
        this.claimProducerService = claimProducerService;
        this.claimMapper = claimMapper;
    }

    // Create or update claim reactively
    @Override
    public ClaimDTO createClaim(CreateClaimDTO createClaimDTO) {
        Claim claim = claimMapper.toClaim(createClaimDTO);
        Claim savedClaim = claimRepository.save(claim);
        claimProducerService.publishClaimCreatedEvent(savedClaim);
        return claimMapper.toClaimDTO(savedClaim);
    }
}
