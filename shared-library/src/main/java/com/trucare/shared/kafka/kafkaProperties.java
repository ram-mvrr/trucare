package com.trucare.shared.kafka;

import lombok.Data;

@Data
public class kafkaProperties {
    public static final String BOOTSTRAP_SERVERS = "localhost:9092";
    public static final String CLAIM_CREATED_TOPIC = "claim_created";
    public static final String CLAIM_UPDATED_TOPIC = "claim_updated";
    public static final String CLAIM_DELETED_TOPIC = "claim_deleted";
    public static final String GROUP_ID = "trucare_group";
}
