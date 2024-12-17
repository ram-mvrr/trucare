package com.trucare.provider.service;

import com.trucare.provider.mapper.ProviderMapper;
import com.trucare.provider.model.Provider;
import com.trucare.provider.repository.ProviderRepository;
import com.trucare.document.shared.provider.ProviderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private ProviderMapper providerMapper;

    @Override
    public ProviderDTO createProvider(ProviderDTO providerDTO) {
        Provider provider = providerMapper.providerDTOToProvider(providerDTO);
        provider = providerRepository.save(provider);
        return providerMapper.providerToProviderDTO(provider);
    }

    @Override
    public ProviderDTO getProviderById(Long id) {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new RuntimeException("Provider not found"));
        return providerMapper.providerToProviderDTO(provider);
    }

    @Override
    public List<ProviderDTO> getAllProviders() {
        List<Provider> providers = providerRepository.findAll();
        return providers.stream()
                .map(providerMapper::providerToProviderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProviderDTO updateProvider(Long id, ProviderDTO providerDTO) {
        Provider provider = providerRepository.findById(id).orElseThrow(() -> new RuntimeException("Provider not found"));
        provider.setName(providerDTO.getName());
        provider.setSpecialization(providerDTO.getSpecialization());
        provider.setContactNumber(providerDTO.getContactNumber());
        provider.setAddress(providerDTO.getAddress());
        provider.setStatus(providerDTO.getStatus());
        provider = providerRepository.save(provider);
        return providerMapper.providerToProviderDTO(provider);
    }

    @Override
    public void deleteProvider(Long id) {
        providerRepository.deleteById(id);
    }
}
