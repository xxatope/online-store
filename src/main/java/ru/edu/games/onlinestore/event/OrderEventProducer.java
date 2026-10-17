package ru.edu.games.onlinestore.event;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderEventProducer {

    public static final String ORDER_CREATED_TOPIC = "order-created-events";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendOrderCreatedEvent(OrderCreatedEvent event){
        log.info("Отправка события OrderCreatedEvent в Kafka для заказа #{}", event.getOrderId());
        kafkaTemplate.send(ORDER_CREATED_TOPIC, event.getOrderId().toString(), event);
    }

}
