package com.trucare.claims.service;


import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;

public interface ClaimService {

     ClaimDTO createClaim(CreateClaimDTO createClaimDTO);
}
