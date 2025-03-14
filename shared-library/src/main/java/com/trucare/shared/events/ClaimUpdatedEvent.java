package com.trucare.shared.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ClaimUpdatedEvent {
    private String claimId;
    private String claimNumber;
    private String memberId;
    private String providerId;
    private BigDecimal claimAmount;
    private String claimStatus;
    private LocalDateTime updatedAt;

    public ClaimUpdatedEvent() {
    }

    public ClaimUpdatedEvent(String claimId, String claimNumber, String memberId, String providerId, BigDecimal claimAmount, String claimStatus, LocalDateTime updatedAt) {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.memberId = memberId;
        this.providerId = providerId;
        this.claimAmount = claimAmount;
        this.claimStatus = claimStatus;
        this.updatedAt = updatedAt;
    }
}

