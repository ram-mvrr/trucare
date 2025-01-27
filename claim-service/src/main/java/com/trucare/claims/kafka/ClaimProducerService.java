package com.trucare.claims.kafka;

import com.trucare.shared.events.ClaimCreatedEvent;
import com.trucare.shared.events.ClaimUpdatedEvent;
import com.trucare.shared.events.ClaimDeletedEvent;
import com.trucare.claims.model.Claim;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ClaimProducerService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    // Define Kafka topic names
    private static final String CLAIM_CREATED_TOPIC = "claim_created";
    private static final String CLAIM_UPDATED_TOPIC = "claim_updated";
    private static final String CLAIM_DELETED_TOPIC = "claim_deleted";

    public ClaimProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Method to publish claim created event
    public void publishClaimCreatedEvent(Claim claim) {
        ClaimCreatedEvent event = new ClaimCreatedEvent(
                claim.getClaimId().toString(),
                claim.getClaimNumber(),
                claim.getMemberId(),
                claim.getProviderId(),
                claim.getClaimAmount(),
                claim.getClaimStatus(),
                claim.getCreatedAt()
        );
        kafkaTemplate.send(CLAIM_CREATED_TOPIC, claim.getClaimId().toString(), event);
    }

    // Method to publish claim updated event
    public void publishClaimUpdatedEvent(Claim claim) {
        ClaimUpdatedEvent event = new ClaimUpdatedEvent(
                claim.getClaimId().toString(),
                claim.getClaimNumber(),
                claim.getMemberId(),
                claim.getProviderId(),
                claim.getClaimAmount(),
                claim.getClaimStatus(),
                claim.getUpdatedAt()
        );
        kafkaTemplate.send(CLAIM_UPDATED_TOPIC, claim.getClaimId().toString(), event);
    }

    // Method to publish claim deleted event
    public void publishClaimDeletedEvent(Claim claim) {
        ClaimDeletedEvent event = new ClaimDeletedEvent(
                claim.getClaimId().toString(),
                claim.getClaimNumber(),
                claim.getUpdatedAt() // Or `deletedAt`, depending on your logic
        );
        kafkaTemplate.send(CLAIM_DELETED_TOPIC, claim.getClaimId().toString(), event);
    }
}


