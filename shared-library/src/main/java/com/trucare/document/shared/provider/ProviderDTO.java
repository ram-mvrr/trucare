package com.trucare.document.shared.provider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {

    private Long id;
    private String name;
    private String specialization;
    private String contactNumber;
    private String address;
    private String status;
}

