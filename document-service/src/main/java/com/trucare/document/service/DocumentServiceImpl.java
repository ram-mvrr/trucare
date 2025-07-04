package com.trucare.document.service;

import com.trucare.document.mapper.DocumentMapper;
import com.trucare.document.model.Document;
import com.trucare.document.repository.DocumentRepository;
import com.trucare.document.utitly.FileUploadStatus;
import com.trucare.shared.document.DocumentDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private DocumentMapper documentMapper;


    //private static final String mountPath = "E:\\Java-projects\\trucare-docs";

    @Value("${document.mountPath}")
    private String mountPath;




    @Override
    public String uploadDocument(MultipartFile multipartFilefile, String memberId, String documentType) throws IOException {
        log.info("uploading files");
        if(multipartFilefile.isEmpty()){
            throw  new IllegalArgumentException("file cann't be empty");
        }
        String name = multipartFilefile.getName();
        Document doc = new Document();
        doc.setDocumentType(documentType);
        doc.setDocumentPath("/trucare-docs");
        doc.setMemberId(memberId);


        doc.setDocumentName(name);
        documentRepository.save(doc);
        File file = new File(mountPath, Objects.requireNonNull(multipartFilefile.getOriginalFilename()));
        multipartFilefile.transferTo(file);

        return "uploaded successfully";
    }

    @Override
    @Transactional
    public List<FileUploadStatus> uploadDocuments(List<MultipartFile> multipartFiles, String memberId, String documentType) throws IOException {

        List<FileUploadStatus> fileUploadStatuses = new ArrayList<>();

        if(multipartFiles.isEmpty()){
            throw  new IllegalArgumentException("file cann't be empty");
        }
        for (MultipartFile multipartFile : multipartFiles) {

            if (!multipartFile.isEmpty()) {
                String uniqueDocPath = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
                try {
                    File file = new File(mountPath, uniqueDocPath);
                    multipartFile.transferTo(file);

                    Document doc = new Document();
                    doc.setDocumentName(multipartFile.getOriginalFilename());
                    doc.setUploadedAt(LocalDateTime.now());
                    doc.setMemberId(memberId);
                    doc.setDocumentPath(mountPath + uniqueDocPath);
                    doc.setDocumentType(documentType);

                    Document savedDocument = documentRepository.save(doc);
                    log.info(multipartFile.getOriginalFilename()+" successfully uploaded");
                    fileUploadStatuses.add(new FileUploadStatus(
                                    multipartFile.getOriginalFilename(),
                                    "SUCCESS",
                                    "uploaded successfully",
                            savedDocument.getId()));
                } catch (IOException e) {
                    log.error("Failed to store file {}",multipartFile.getOriginalFilename(),e);
                    fileUploadStatuses.add(new FileUploadStatus(
                            multipartFile.getOriginalFilename(),
                            "FAILED",
                            "IOException"+ e.getMessage(),
                            null));
                }

            } else {
                log.info(multipartFile + " file is empty");
                fileUploadStatuses.add(new FileUploadStatus(
                        multipartFile.getOriginalFilename(),
                        "FAILED",
                        "Failed due to file is empty", null));
            }
        }
        return fileUploadStatuses;
    }

    @Override
    public DocumentDTO getDocumentById(Long id) {
        Document document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
        return documentMapper.documentToDocumentDTO(document);
    }

    @Override
    public List<DocumentDTO> getDocumentsByClaimId(Long id) {
        Optional<Document> documents = documentRepository.findById(id);
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

//    @Override
//    public DocumentDTO updateDocument(Long id, DocumentDTO documentDTO) {
//        Document document = documentRepository.findById(id).orElseThrow(() -> new RuntimeException("Document not found"));
//        document.setDocumentType(documentDTO.getDocumentType());
//        document.setDocumentName(documentDTO.getDocumentName());
//        document.setDocumentPath(documentDTO.getDocumentPath());
//        document.setUploadedAt(documentDTO.getUploadedAt());
//        document = documentRepository.save(document);
//        return documentMapper.documentToDocumentDTO(document);
//    }

    @Override
    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    @Override
    public List<Long> validateDocumetns(List<Long> documentIds) {
        return documentIds.stream().filter(documentId -> !documentRepository.existsById(documentId))
                .toList();
    }
}
