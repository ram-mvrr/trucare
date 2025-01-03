package com.trucare.shared.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentDTO {

    private Long id;

    private Long claimId;

    private String documentName;

    private String documentUrl;

    private LocalDateTime uploadedAt;
}

