package com.trucare.claims.kafka;

import com.trucare.claims.model.Claim;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClaimProducerService {

    private final KafkaTemplate<String, Claim> kafkaTemplate;

    // Define Kafka topic names
    private static final String CLAIM_CREATED_TOPIC = "claim_created";
    private static final String CLAIM_UPDATED_TOPIC = "claim_updated";
    private static final String CLAIM_DELETED_TOPIC = "claim_deleted";

    public ClaimProducerService(KafkaTemplate<String, Claim> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method to publish claim created event
    public void publishClaimCreatedEvent(Claim claim){
        kafkaTemplate.send(CLAIM_CREATED_TOPIC, claim.getClaimId().toString(), claim);
    }

    // Method to publish claim updated event
    public void publishClaimUpdatedEvent(Claim claim) {
        kafkaTemplate.send(CLAIM_UPDATED_TOPIC, claim.getClaimId().toString(), claim);
    }

    // Method to publish claim deleted event
    public void publishClaimDeletedEvent(Claim claim) {
        kafkaTemplate.send(CLAIM_DELETED_TOPIC, claim.getClaimId().toString(), claim);
    }
}

