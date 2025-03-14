package com.trucare.claims.mapper;

import com.trucare.claims.model.Claim;
import com.trucare.shared.claim.ClaimDTO;
import com.trucare.shared.claim.CreateClaimDTO;
import com.trucare.shared.claim.UpdateClaimDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T15:13:33+0530",
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

        claimDTO.setClaimId( claim.getClaimId() );
        if ( claim.getClaimNumber() != null ) {
            claimDTO.setClaimNumber( Long.parseLong( claim.getClaimNumber() ) );
        }
        if ( claim.getMemberId() != null ) {
            claimDTO.setMemberId( Long.parseLong( claim.getMemberId() ) );
        }
        if ( claim.getProviderId() != null ) {
            claimDTO.setProviderId( Long.parseLong( claim.getProviderId() ) );
        }
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

        claim.setClaimId( claimDTO.getClaimId() );
        if ( claimDTO.getClaimNumber() != null ) {
            claim.setClaimNumber( String.valueOf( claimDTO.getClaimNumber() ) );
        }
        if ( claimDTO.getMemberId() != null ) {
            claim.setMemberId( String.valueOf( claimDTO.getMemberId() ) );
        }
        if ( claimDTO.getProviderId() != null ) {
            claim.setProviderId( String.valueOf( claimDTO.getProviderId() ) );
        }
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

        if ( createClaimDTO.getClaimNumber() != null ) {
            claim.setClaimNumber( String.valueOf( createClaimDTO.getClaimNumber() ) );
        }
        claim.setMemberId( createClaimDTO.getMemberId() );
        claim.setProviderId( createClaimDTO.getProviderId() );
        claim.setClaimAmount( createClaimDTO.getClaimAmount() );
        claim.setCreatedAt( createClaimDTO.getCreatedAt() );
        claim.setUpdatedAt( createClaimDTO.getUpdatedAt() );

        return claim;
    }

    @Override
    public Claim toClaim(UpdateClaimDTO updateClaimDTO) {
        if ( updateClaimDTO == null ) {
            return null;
        }

        Claim claim = new Claim();

        claim.setClaimId( updateClaimDTO.getClaimId() );
        if ( updateClaimDTO.getClaimNumber() != null ) {
            claim.setClaimNumber( String.valueOf( updateClaimDTO.getClaimNumber() ) );
        }
        if ( updateClaimDTO.getMemberId() != null ) {
            claim.setMemberId( String.valueOf( updateClaimDTO.getMemberId() ) );
        }
        if ( updateClaimDTO.getProviderId() != null ) {
            claim.setProviderId( String.valueOf( updateClaimDTO.getProviderId() ) );
        }
        claim.setClaimAmount( updateClaimDTO.getClaimAmount() );
        claim.setCreatedAt( updateClaimDTO.getCreatedAt() );
        claim.setUpdatedAt( updateClaimDTO.getUpdatedAt() );

        return claim;
    }
}
