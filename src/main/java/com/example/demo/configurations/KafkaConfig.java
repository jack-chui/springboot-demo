package com.example.demo.configurations;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@Configuration
@EnableKafka
public class KafkaConfig {
    public static final String TOPIC = "order.new";

    @Bean
    public NewTopic topic() {
        return new NewTopic(TOPIC, 2, (short) 1);
    }
}
