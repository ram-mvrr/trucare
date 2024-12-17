package com.trucare.claims.kafka;

import org.springframework.stereotype.Service;

@Service
public class ClaimProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ClaimProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendClaim(String claim) {
        kafkaTemplate.send("claims-topic", claim);
    }
}

