package com.trucare.document.service;


import com.trucare.shared.document.DocumentDTO;

import java.util.List;

public interface DocumentService {

    // Create Document
    DocumentDTO createDocument(DocumentDTO documentDTO);

    // Get Document by ID
    DocumentDTO getDocumentById(Long id);

    // Get Documents by Claim ID
    List<DocumentDTO> getDocumentsByClaimId(Long claimId);

    // Get all Documents
    List<DocumentDTO> getAllDocuments();

    // Update Document
    DocumentDTO updateDocument(Long id, DocumentDTO documentDTO);

    // Delete Document
    void deleteDocument(Long id);
}
