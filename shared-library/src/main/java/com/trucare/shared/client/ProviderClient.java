package com.trucare.shared.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-service")
public interface ProviderClient {

    @GetMapping("/validate/{providerId}")
    Boolean validateProvider(@PathVariable("providerId") String providerId);
}
