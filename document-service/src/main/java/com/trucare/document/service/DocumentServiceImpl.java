package com.trucare.document.service;

import com.trucare.document.mapper.DocumentMapper;
import com.trucare.document.model.Document;
import com.trucare.document.repository.DocumentRepository;
import com.trucare.document.shared.document.DocumentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public DocumentDTO createDocument(DocumentDTO documentDTO) {
        Document document = documentMapper.documentDTOToDocument(documentDTO);
        document = documentRepository.save(document);
        return documentMapper.documentToDocumentDTO(document);
    }

    @Override
    public DocumentDTO getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        return documentMapper.documentToDocumentDTO(document);
    }

    @Override
    public List<DocumentDTO> getDocumentsByClaimId(Long claimId) {
        List<Document> documents = documentRepository.findByClaimId(claimId);
        return documents.stream()
                .map(documentMapper::documentToDocumentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentDTO> getAllDocuments() {
        List<Document> documents = documentRepository.findAll();
        return documents.stream()
                .map(documentMapper::documentToDocumentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) {
        Document document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        document.setClaimId(documentDTO.getClaimId());
        document.setDocumentName(documentDTO.getDocumentName());
        document.setDocumentUrl(documentDTO.getDocumentUrl());
        document.setUploadedAt(documentDTO.getUploadedAt());
        document = documentRepository.save(document);
        return documentMapper.documentToDocumentDTO(document);
    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }
}
