package com.trucare.document.service;


import com.trucare.document.utitly.FileUploadStatus;
import com.trucare.shared.document.DocumentDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface DocumentService {

    // Create Document



    String uploadDocument(MultipartFile file, String memberId, String documentType) throws IOException;

    List<FileUploadStatus> uploadDocuments(List<MultipartFile> files, String memberId, String documentType) throws IOException;

    // Get Document by ID
    DocumentDTO getDocumentById(Long id);

    // Get Documents by Claim ID
    List<DocumentDTO> getDocumentsByClaimId(Long claimId);

    // Get all Documents
    List<DocumentDTO> getAllDocuments();

    // Update Document
    //DocumentDTO updateDocument(Long id, DocumentDTO documentDTO);

    // Delete Document
    void deleteDocument(Long id);

    List<Long> validateDocumetns(List<Long> documentIds);
}
