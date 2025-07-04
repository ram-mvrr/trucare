package com.trucare.claims.mapper;

import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import com.trucare.shared.claim.UpdateClaimDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-02T06:42:58+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class ClaimMapperImpl implements ClaimMapper {

    @Override
    public ClaimDTO toClaimDTO(Claim claim) {
        if ( claim == null ) {
            return null;
        }

        ClaimDTO claimDTO = new ClaimDTO();

        claimDTO.setId( claim.getId() );
        claimDTO.setClaimId( claim.getClaimId() );
        claimDTO.setMemberId( claim.getMemberId() );
        claimDTO.setProviderId( claim.getProviderId() );
        claimDTO.setClaimAmount( claim.getClaimAmount() );
        claimDTO.setCreatedAt( claim.getCreatedAt() );
        claimDTO.setUpdatedAt( claim.getUpdatedAt() );

        return claimDTO;
    }

    @Override
    public Claim toClaim(ClaimDTO claimDTO) {
        if ( claimDTO == null ) {
            return null;
        }

        Claim claim = new Claim();

        claim.setId( claimDTO.getId() );
        claim.setClaimId( claimDTO.getClaimId() );
        claim.setMemberId( claimDTO.getMemberId() );
        claim.setProviderId( claimDTO.getProviderId() );
        claim.setClaimAmount( claimDTO.getClaimAmount() );
        claim.setCreatedAt( claimDTO.getCreatedAt() );
        claim.setUpdatedAt( claimDTO.getUpdatedAt() );

        return claim;
    }

    @Override
    public Claim toClaim(CreateClaimDTO createClaimDTO) {
        if ( createClaimDTO == null ) {
            return null;
        }

        Claim claim = new Claim();

        claim.setClaimId( createClaimDTO.getClaimId() );
        claim.setMemberId( createClaimDTO.getMemberId() );
        claim.setProviderId( createClaimDTO.getProviderId() );
        claim.setClaimAmount( createClaimDTO.getClaimAmount() );
        claim.setCreatedAt( createClaimDTO.getCreatedAt() );
        claim.setUpdatedAt( createClaimDTO.getUpdatedAt() );
        List<Long> list = createClaimDTO.getDocumentIds();
        if ( list != null ) {
            claim.setDocumentIds( new ArrayList<Long>( list ) );
        }

        return claim;
    }

    @Override
    public Claim toClaim(UpdateClaimDTO updateClaimDTO) {
        if ( updateClaimDTO == null ) {
            return null;
        }

        Claim claim = new Claim();

        claim.setId( updateClaimDTO.getId() );
        claim.setClaimId( updateClaimDTO.getClaimId() );
        claim.setMemberId( updateClaimDTO.getMemberId() );
        claim.setProviderId( updateClaimDTO.getProviderId() );
        claim.setClaimAmount( updateClaimDTO.getClaimAmount() );
        claim.setCreatedAt( updateClaimDTO.getCreatedAt() );
        claim.setUpdatedAt( updateClaimDTO.getUpdatedAt() );

        return claim;
    }
}
