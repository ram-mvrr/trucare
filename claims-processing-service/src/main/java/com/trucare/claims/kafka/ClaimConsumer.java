package com.trucare.claims.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClaimConsumer {

    @KafkaListener(topics = "claims-topic", groupId = "claims-group")
    public void consume(String claim) {
        // Process the claim (e.g., save to DB or trigger further actions)
        System.out.println("Received claim: " + claim);
    }
}

