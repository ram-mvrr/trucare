package com.trucare.claims.mapper;


import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import com.trucare.shared.claim.UpdateClaimDTO;
import com.trucare.shared.document.DocumentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring")
public interface ClaimMapper {

    ClaimDTO toClaimDTO(Claim claim);

    Claim toClaim(ClaimDTO claimDTO);

    Claim toClaim(CreateClaimDTO createClaimDTO);

    Claim toClaim(UpdateClaimDTO updateClaimDTO);

}
