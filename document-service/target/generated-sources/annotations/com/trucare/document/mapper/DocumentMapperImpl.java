package com.trucare.document.mapper;

import com.trucare.document.model.Document;
import com.trucare.shared.document.DocumentDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-01T16:09:53+0530",
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

        return documentDTO;
    }

    @Override
    public Document documentDTOToDocument(DocumentDTO documentDTO) {
        if ( documentDTO == null ) {
            return null;
        }

        Document document = new Document();

        return document;
    }
}
