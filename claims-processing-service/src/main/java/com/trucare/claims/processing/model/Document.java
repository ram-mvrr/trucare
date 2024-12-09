package com.trucare.claims.processing.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "documents")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "claim_id", nullable = false)
    private Long claim;

    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "document_type")
    private String documentType;
}

