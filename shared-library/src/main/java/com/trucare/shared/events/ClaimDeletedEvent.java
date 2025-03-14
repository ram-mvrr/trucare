package com.trucare.shared.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class ClaimDeletedEvent {
    private String claimId;
    private String claimNumber;
    private LocalDateTime deletedAt;

    public ClaimDeletedEvent(String claimId, String claimNumber, LocalDateTime deletedAt) {
        this.claimId = claimId;
        this.claimNumber = claimNumber;
        this.deletedAt = deletedAt;
    }

    public ClaimDeletedEvent() {
    }
}

