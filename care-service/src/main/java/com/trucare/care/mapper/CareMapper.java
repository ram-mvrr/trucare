package com.trucare.care.mapper;

import com.trucare.care.model.Care;
import com.trucare.shared.care.CareDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CareMapper {

    CareMapper INSTANCE = Mappers.getMapper(CareMapper.class);

    CareDTO careToCareDTO(Care care);

    Care careDTOToCare(CareDTO careDTO);
}

