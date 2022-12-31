package com.example.demo.consumers;

import com.example.demo.configurations.RabbitMQConfig;
import jakarta.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class RabbitMQConsumer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init() {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, "Hello Jack");
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void consume(String message) {
        log.info("Receive RabbitMQ message: {}", message);
    }
}
