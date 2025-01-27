package com.trucare.claims.mapper;


import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import com.trucare.shared.claim.UpdateClaimDTO;
import com.trucare.shared.document.DocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClaimMapper {

    ClaimDTO toClaimDTO(Claim claim);

    Claim toClaim(ClaimDTO claimDTO);

    Claim toClaim(CreateClaimDTO createClaimDTO);

    Claim toClaim(UpdateClaimDTO updateClaimDTO);

}
