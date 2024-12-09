package com.trucare.claims.processing.service;

import com.trucare.claims.processing.dto.ClaimDTO;
import com.trucare.claims.processing.exception.ResourceNotFoundException;
import com.trucare.claims.processing.mapper.ClaimMapper;
import com.trucare.claims.processing.model.Claim;
import com.trucare.claims.processing.model.ClaimStatus;
import com.trucare.claims.processing.model.Document;
import com.trucare.claims.processing.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimMapper claimMapper;

    @Autowired
    public ClaimService(ClaimRepository claimRepository, ClaimMapper claimMapper) {
        this.claimRepository = claimRepository;
        this.claimMapper = claimMapper;
    }

    // Get all claims
    public List<ClaimDTO> getAllClaims() {
        List<Claim> claims = claimRepository.findAll();
        return claimMapper.toClaimDTOList(claims);
    }

    // Save a new claim
    public ClaimDTO saveClaim(ClaimDTO claimDTO) {
        Claim claim = claimMapper.toClaim(claimDTO);
        Claim savedClaim = claimRepository.save(claim);
        return claimMapper.toClaimDTO(savedClaim);
    }

    // Get claim by ID
    public Optional<ClaimDTO> getClaimById(Long id) {
        return claimRepository.findById(id).map(claimMapper::toClaimDTO);
    }

    // Update an existing claim
    public ClaimDTO updateClaim(Long claimId, ClaimDTO claimDTO) throws ResourceNotFoundException {
        Claim existingClaim = claimRepository.findById(claimId)
                .orElseThrow(() -> new ResourceNotFoundException("Claim is not found with claim id " + claimId));

        // Update fields
        existingClaim.setClaimAmount(claimDTO.getClaimAmount());
        existingClaim.setDateOfService(claimDTO.getDateOfService());
        existingClaim.setProviderId(claimDTO.getProviderId());
        existingClaim.setMemberId(claimDTO.getMemberId());
        existingClaim.setDescription(claimDTO.getDescription());

        // Handle ClaimStatus and Document updates if needed
        List<ClaimStatus> claimStatuses = claimMapper.toClaimStatusEntities(claimDTO.getClaimStatuses());
        List<Document> documents = claimMapper.toDocumentsEntities(claimDTO.getDocuments());

        // Save the updated claim with new statuses and documents if necessary
        existingClaim.setClaimStatuses(claimStatuses); // Ensure Claim entity has a method to set claim statuses
        existingClaim.setDocuments(documents); // Ensure Claim entity has a method to set documents

        // Save the updated claim back to the repository
        Claim updatedClaim = claimRepository.save(existingClaim);
        return claimMapper.toClaimDTO(updatedClaim);
    }

    // Delete a claim
    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }
}

