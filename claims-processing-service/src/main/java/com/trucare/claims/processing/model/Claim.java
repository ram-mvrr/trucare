package com.trucare.claims.processing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "claims")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "provider_id" , nullable = false)
    private Long providerId;

    @Column(name = "claim_amount", nullable = false)
    private BigDecimal claimAmount;

    @Column(name = "description")
    private String description;

    @Column(name = "date_of_service", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfService;


}
