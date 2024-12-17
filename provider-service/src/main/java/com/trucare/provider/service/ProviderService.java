package com.trucare.provider.service;


import com.trucare.document.shared.provider.ProviderDTO;

import java.util.List;

public interface ProviderService {

    // Create Provider
    ProviderDTO createProvider(ProviderDTO providerDTO);

    // Get Provider by ID
    ProviderDTO getProviderById(Long id);

    // Get all Providers
    List<ProviderDTO> getAllProviders();

    // Update Provider
    ProviderDTO updateProvider(Long id, ProviderDTO providerDTO);

    // Delete Provider
    void deleteProvider(Long id);
}
