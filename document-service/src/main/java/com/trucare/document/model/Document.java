package com.trucare.document.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "document")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    private Long claimId;  // Associated claim ID

    private String documentName;  // Name of the document

    private String documentUrl;  // S3 bucket URL or path

    private LocalDateTime uploadedAt;  // Upload timestamp
}
