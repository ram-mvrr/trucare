package com.trucare.claims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClaimStatusDTO {
    private Long id;
    // private Long claimId; // If needed; otherwise, can be removed
    private String status;
    private Date updatedDate;
}

