package com.trucare.document.mapper;

import com.trucare.shared.document.DocumentDTO;
import com.trucare.document.model.Document;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentMapper {

    DocumentMapper INSTANCE = Mappers.getMapper(DocumentMapper.class);

    DocumentDTO documentToDocumentDTO(Document document);

    Document documentDTOToDocument(DocumentDTO documentDTO);
}
