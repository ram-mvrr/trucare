package com.trucare.claims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {
    private Long id;
    //private Long claimId; // If needed; otherwise, can be removed
    private String filePath;
    private String documentType;
}

