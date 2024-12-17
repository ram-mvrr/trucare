package com.trucare.care.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "care")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Care {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    private String memberId;  // Associated member ID

    private String diagnosis;  // Diagnosis details

    private String careProviderId;  // Assigned provider ID

    private LocalDate startDate;  // Care plan start date

    private LocalDate endDate;  // Estimated end date

    private String status;  // ACTIVE, COMPLETED, CANCELED
}
