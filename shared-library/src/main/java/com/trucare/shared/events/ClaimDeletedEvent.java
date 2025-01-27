package com.trucare.shared.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimDeletedEvent {
    private String claimId;
    private String claimNumber;
    private LocalDateTime deletedAt;
}

