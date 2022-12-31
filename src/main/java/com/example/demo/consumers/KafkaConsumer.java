package com.example.demo.consumers;

import com.example.demo.configurations.KafkaConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Log4j2
@Component
public class KafkaConsumer {
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @PostConstruct
    public void init() {
        kafkaTemplate.send(KafkaConfig.TOPIC, "Hello Jack " + new Date());
    }

    @KafkaListener(topics = { KafkaConfig.TOPIC }, groupId = "demo-group")
    public void consume(String message) {
        log.info("Receive Kafka message: {}", message);
    }
}
