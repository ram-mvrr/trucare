package com.trucare.claims.processing.mapper;


import com.trucare.claims.processing.dto.ClaimDTO;
import com.trucare.claims.processing.dto.ClaimStatusDTO;
import com.trucare.claims.processing.dto.DocumentDTO;
import com.trucare.claims.processing.model.Claim;
import com.trucare.claims.processing.model.ClaimStatus;
import com.trucare.claims.processing.model.Document;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ClaimMapper {

    @Mapping(source = "Claim.claimStatuses", target = "claimStatuses")
    @Mapping(source = "Claim.documents", target = "documents")
    ClaimDTO toClaimDTO(Claim claim);

    @Mapping(source = "claimStatuses", target = "claimStatuses")
    @Mapping(source = "documents", target = "documents")
    Claim toClaim(ClaimDTO claimDTO);

    List<ClaimDTO> toClaimDTOList(List<Claim> claims);

    List<Claim> toClaimEntities(List<ClaimDTO> claimDTOs);

    // Nested mappers for related entities
    ClaimStatusDTO toClaimStatusDTO(ClaimStatus claimStatus);
    ClaimStatus toClaimStatus(ClaimStatusDTO claimStatusDTO);

    DocumentDTO toDocumentDTO(Document document);
    Document toDocument(DocumentDTO documentDTO);

    List<ClaimStatus> toClaimStatusEntities(List<ClaimStatusDTO> claimStatusDTOs);
    List<Document> toDocumentsEntities(List<DocumentDTO> documentDTOS);

}
