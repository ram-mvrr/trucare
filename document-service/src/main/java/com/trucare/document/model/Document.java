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

    private String documentName;  // Name of the document

    private String documentPath;

    private String documentType; // e.g., BILL, PRESCRIPTION, etc.

    private String memberId;

    private LocalDateTime uploadedAt;  // Upload timestamp
}
