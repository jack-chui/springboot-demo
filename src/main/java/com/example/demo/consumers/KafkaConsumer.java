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
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostConstruct
    public void init() throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            kafkaTemplate.send(KafkaConfig.TOPIC, String.valueOf(i), "New Order " + i);
//            Thread.sleep(500);
        }
    }

    @KafkaListener(topics = { KafkaConfig.TOPIC }, groupId = "group.new-order")
    public void consume1(String message) {
        try {
            log.info("Receive Kafka message in 1: {}", message);
            Thread.sleep(1000);
        } catch (Exception e) {
            log.error(e);
        }
    }

    @KafkaListener(topics = { KafkaConfig.TOPIC }, groupId = "group.new-order")
    public void consume2(String message) {
        try {
            log.info("Receive Kafka message in 2: {}", message);
            Thread.sleep(1000);
        } catch (Exception e) {
            log.error(e);
        }
    }
}
