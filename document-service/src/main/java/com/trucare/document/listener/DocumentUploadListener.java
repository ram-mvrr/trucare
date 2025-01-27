package com.trucare.document.listener;

import com.trucare.document.model.Document;
import com.trucare.document.repository.DocumentRepository;
import com.trucare.shared.document.DocumentDTO;
import com.trucare.shared.events.DocumentUploadEvent;
import com.trucare.shared.events.DocumentUploadedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentUploadListener {

    private final DocumentRepository documentRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public DocumentUploadListener(DocumentRepository documentRepository, KafkaTemplate<String, Object> kafkaTemplate) {
        this.documentRepository = documentRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "document.upload", groupId = "document-service")
    public void handleDocumentUpload(DocumentUploadEvent event) {
        List<String> documentIds = new ArrayList<>();

        for (DocumentDTO document : event.getDocuments()) {
            String documentId = uploadDocumentToS3(document);
            documentIds.add(documentId);

            // Save document metadata
            Document doc = new Document();
            doc.setClaimId(event.getClaimId());
            doc.setDocumentName(document.getDocumentName());
            doc.setDocumentUrl(documentId);
            documentRepository.save(doc);
        }

        // Publish Document Uploaded Event
        kafkaTemplate.send("document.uploaded", new DocumentUploadedEvent(event.getClaimId(), documentIds));
    }

    private String uploadDocumentToS3(DocumentDTO document) {
        // Logic to upload document to S3 and return the URL
        return "s3://bucket/" + document.getDocumentName();
    }
}

