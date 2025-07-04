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

    private String documentName;

    private String documentPath;

    private String documentType; // e.g., BILL, PRESCRIPTION, etc.

    private String uploadedByMemberId;

    private LocalDateTime uploadedAt;
}

