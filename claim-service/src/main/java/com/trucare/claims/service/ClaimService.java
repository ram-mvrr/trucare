package com.trucare.claims.service;


import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import com.trucare.shared.claim.UpdateClaimDTO;

import java.util.List;

public interface ClaimService {

     ClaimDTO createClaim(CreateClaimDTO createClaimDTO);
     ClaimDTO getClaimById(Long claimId);
     List<ClaimDTO> getAllClaims();
     ClaimDTO updateClaim(String claimId, UpdateClaimDTO updateClaimDTO);
     String deleteClaim(Long claimId);
}
