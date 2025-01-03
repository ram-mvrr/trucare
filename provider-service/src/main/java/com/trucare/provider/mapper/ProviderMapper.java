package com.trucare.provider.mapper;


import com.trucare.provider.model.Provider;
import com.trucare.shared.provider.ProviderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProviderMapper {

    ProviderMapper INSTANCE = Mappers.getMapper(ProviderMapper.class);

    ProviderDTO providerToProviderDTO(Provider provider);

    Provider providerDTOToProvider(ProviderDTO providerDTO);
}
