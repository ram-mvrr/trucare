package com.trucare.document.utitly;

import java.util.Optional;

public record FileUploadStatus(String fileName, String status, String message, Long documentId) {}

