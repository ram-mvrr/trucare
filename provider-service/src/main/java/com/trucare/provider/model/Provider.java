package com.trucare.provider.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "provider")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Primary key

    @NotNull
    private String name;  // Provider's name

    private String specialization;  // Provider's specialty

    private String contactNumber;  // Provider's phone number

    private String address;  // Provider's address

    @NotNull
    private String status;  // ACTIVE, INACTIVE
}
