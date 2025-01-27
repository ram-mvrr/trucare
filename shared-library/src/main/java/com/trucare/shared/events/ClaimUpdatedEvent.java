package com.trucare.shared.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimUpdatedEvent {
    private String claimId;
    private String claimNumber;
    private String memberId;
    private String providerId;
    private BigDecimal claimAmount;
    private String claimStatus;
    private LocalDateTime updatedAt;
}

