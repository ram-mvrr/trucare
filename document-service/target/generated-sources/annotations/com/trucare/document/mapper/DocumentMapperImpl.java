package com.trucare.document.mapper;

import com.trucare.document.model.Document;
import com.trucare.shared.document.DocumentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-09-22T18:50:18+0530",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.11 (Oracle Corporation)"
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
        documentDTO.setDocumentName( document.getDocumentName() );
        documentDTO.setDocumentPath( document.getDocumentPath() );
        documentDTO.setDocumentType( document.getDocumentType() );
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
        document.setDocumentName( documentDTO.getDocumentName() );
        document.setDocumentPath( documentDTO.getDocumentPath() );
        document.setDocumentType( documentDTO.getDocumentType() );
        document.setUploadedAt( documentDTO.getUploadedAt() );

        return document;
    }
}
