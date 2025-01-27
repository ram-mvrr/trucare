package com.trucare.shared.events;

import com.trucare.shared.document.DocumentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentUploadEvent {
    private Long claimId;
    private List<DocumentDTO> documents;
}
