package com.trucare.claims.controller;


import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ClaimDTO> createOrUpdateClaim(@RequestBody CreateClaimDTO createClaimDTO) {
        ClaimDTO createdClaim = claimService.createClaim(createClaimDTO);
        return new ResponseEntity<>(createdClaim,HttpStatus.CREATED);

    }
}

