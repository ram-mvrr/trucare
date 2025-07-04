package com.trucare.provider.controller;

import com.trucare.provider.service.ProviderService;
import com.trucare.shared.provider.ProviderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    @PostMapping
    public ResponseEntity<ProviderDTO> createProvider(@RequestBody ProviderDTO providerDTO) {
        return ResponseEntity.ok(providerService.createProvider(providerDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProviderDTO> getProviderById(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.getProviderById(id));
    }
    @GetMapping("/validate/{providerId}")
    public ResponseEntity<Boolean> validateProvider(@PathVariable String providerId) {
        Boolean isValidated = providerService.validateProvider(providerId);
        return new ResponseEntity<>(isValidated, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProviderDTO>> getAllProviders() {
        return ResponseEntity.ok(providerService.getAllProviders());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProviderDTO> updateProvider(@PathVariable Long id, @RequestBody ProviderDTO providerDTO) {
        return ResponseEntity.ok(providerService.updateProvider(id, providerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }
}

