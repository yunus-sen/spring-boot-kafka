package com.yunussen.kafkademo.kafka.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
public class KafkaLogModel implements Serializable {
    @NotBlank
    private String type;

    @NotBlank
    private String hostname;

    private transient Map<String, Object> attributes;

    public KafkaLogModel() {
        attributes = new HashMap<>();
    }
    public KafkaLogModel(String type, String hostname) {
        this();
        this.type = type;
        this.hostname = hostname;
    }

    public KafkaLogModel(String type, String hostname, Map<String, Object> attributes) {
        this.type = type;
        this.hostname = hostname;
        this.attributes = attributes;
    }
}
