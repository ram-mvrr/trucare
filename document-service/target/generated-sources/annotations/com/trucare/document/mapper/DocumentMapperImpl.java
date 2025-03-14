package com.trucare.document.mapper;

import com.trucare.document.model.Document;
import com.trucare.shared.document.DocumentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-12T15:50:58+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class DocumentMapperImpl implements DocumentMapper {

    @Override
    public DocumentDTO documentToDocumentDTO(Document document) {
        if ( document == null ) {
            return null;
        }

        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setId( document.getId() );
        documentDTO.setClaimId( document.getClaimId() );
        documentDTO.setDocumentName( document.getDocumentName() );
        documentDTO.setDocumentUrl( document.getDocumentUrl() );
        documentDTO.setUploadedAt( document.getUploadedAt() );

        return documentDTO;
    }

    @Override
    public Document documentDTOToDocument(DocumentDTO documentDTO) {
        if ( documentDTO == null ) {
            return null;
        }

        Document document = new Document();

        document.setId( documentDTO.getId() );
        document.setClaimId( documentDTO.getClaimId() );
        document.setDocumentName( documentDTO.getDocumentName() );
        document.setDocumentUrl( documentDTO.getDocumentUrl() );
        document.setUploadedAt( documentDTO.getUploadedAt() );

        return document;
    }
}
