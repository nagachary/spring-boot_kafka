package com.naga.kafka.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.support.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Value("${kafka.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, UUID.randomUUID().toString(), message);

        future.whenComplete((result, exception) -> {
            if (null == exception) {
                logger.info(String.format("Produced event to topic %s: message = %s", result.getRecordMetadata().topic(), message));
            } else {
                logger.error("exception occurred : ", exception);
            }
        });
    }
}
