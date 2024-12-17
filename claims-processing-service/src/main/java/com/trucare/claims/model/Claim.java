package com.trucare.claims.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "claims")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key for the claim

    @Column(unique = true)
    private String claimNumber;  // Unique claim number

    private String memberId;  // ID of the member

    private String providerId;  // ID of the provider

    private BigDecimal amount;  // Claim amount

    private String status;  // CLAIMED, APPROVED, REJECTED

    private LocalDateTime createdAt;  // Claim creation date

    private LocalDateTime updatedAt;  // Last updated timestamp
}
