package com.trucare.shared.claim;

import com.trucare.shared.document.DocumentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateClaimDTO {

    private String claimId;
    private String memberId; // Can be expanded to MemberDTO if needed
    private String providerId; // Can be expanded to ProviderDTO if needed
    private BigDecimal claimAmount;
    private String claimStatuses; // Relationship to ClaimStatusDTO
    private LocalDateTime createdAt;  // Claim creation date
    private LocalDateTime updatedAt;
    private List<Long> documentIds;
}
