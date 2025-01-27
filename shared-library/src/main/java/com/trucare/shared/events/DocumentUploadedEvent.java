package com.trucare.shared.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentUploadedEvent {
    private Long claimId;
    private List<String> documentIds;
}
