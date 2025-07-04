package com.trucare.document.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "document-service")
public interface DocumentClient {

    @GetMapping("/validateDocs/{documentIds}")
    List<Long> validateDocuments(@PathVariable List<Long> documentIds);
}
