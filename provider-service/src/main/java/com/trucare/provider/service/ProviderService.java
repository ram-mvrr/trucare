package com.trucare.provider.service;


import com.trucare.shared.provider.ProviderDTO;

import java.util.List;

public interface ProviderService {

    // Create Provider
    ProviderDTO createProvider(ProviderDTO providerDTO);

    // Validate Provider
    boolean validateProvider(String providerId);

    // Get Provider by ID
    ProviderDTO getProviderById(Long id);

    //ProviderDTO getProviderByProviderId(String providerId);

    // Get all Providers
    List<ProviderDTO> getAllProviders();

    // Update Provider
    ProviderDTO updateProvider(Long id, ProviderDTO providerDTO);

    // Delete Provider
    void deleteProvider(Long id);
}
