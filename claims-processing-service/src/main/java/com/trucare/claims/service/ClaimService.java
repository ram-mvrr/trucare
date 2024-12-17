package com.trucare.claims.service;

import com.trucare.claims.kafka.ClaimProducer;
import com.trucare.claims.model.Claim;
import com.trucare.claims.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;
    private final ClaimProducer claimProducer;

    @Autowired
    public ClaimService(ClaimRepository claimRepository, ClaimProducer claimProducer) {
        this.claimRepository = claimRepository;
        this.claimProducer = claimProducer;
    }

    // Create or update claim reactively
    public Mono<Claim> createOrUpdateClaim(Claim claim) {
        claim.setCreatedAt(LocalDateTime.now());
        claim.setUpdatedAt(LocalDateTime.now());
        return claimRepository.save(claim)
                .doOnSuccess(savedClaim -> claimProducer.sendClaim(savedClaim.toString()));  // Kafka async messaging
    }

    // Find claim by id
    public Mono<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    // Delete claim by id reactively
    public Mono<Void> deleteClaim(Long id) {
        return claimRepository.deleteById(id);
    }
}
