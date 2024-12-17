package com.trucare.claims.controller;


import com.trucare.claims.model.Claim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import com.trucare.claims.service.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    private final ClaimService claimService;

    @Autowired
    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    // Endpoint to create or update claim
    @PostMapping
    public Mono<Claim> createOrUpdateClaim(@RequestBody Claim claim) {
        return claimService.createOrUpdateClaim(claim);
    }

    // Endpoint to get claim by id
    @GetMapping("/{id}")
    public Mono<Claim> getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    // Endpoint to delete claim by id
    @DeleteMapping("/{id}")
    public Mono<Void> deleteClaim(@PathVariable Long id) {
        return claimService.deleteClaim(id);
    }
}

