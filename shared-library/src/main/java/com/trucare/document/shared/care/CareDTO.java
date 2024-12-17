package com.trucare.document.shared.care;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CareDTO {

    private Long id;

    private String memberId;

    private String diagnosis;

    private String careProviderId;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;
}

