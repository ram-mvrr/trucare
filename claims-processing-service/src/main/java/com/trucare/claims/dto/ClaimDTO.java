package com.trucare.claims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimDTO {
    private Long claimId;
    private Long memberId; // Can be expanded to MemberDTO if needed
    private Long providerId; // Can be expanded to ProviderDTO if needed
    private BigDecimal claimAmount;
    private String description;
    private Date dateOfService;
    private List<ClaimStatusDTO> claimStatuses; // Relationship to ClaimStatusDTO
    private List<DocumentDTO> documents; // Relationship to a list of DocumentDTOs
}

