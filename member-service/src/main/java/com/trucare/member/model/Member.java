package com.trucare.member.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "member")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key is String as per the requirement

    @Column(unique = true)
    private String memberId;

    @NotNull
    private String firstName; // Member's first name

    @NotNull
    private String lastName; // Member's last name

    private LocalDate dateOfBirth; // Date of birth

    @NotNull
    private String gender; // MALE, FEMALE, OTHER

    private String contactNumber; // Member's phone number

    private String address; // Member's address

    // List of document IDs that belong to the member
    private List<Long> documentIds;

}
