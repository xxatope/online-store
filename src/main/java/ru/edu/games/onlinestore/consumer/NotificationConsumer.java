package ru.edu.games.onlinestore.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.BackOff;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.stereotype.Component;
import ru.edu.games.onlinestore.event.OrderCreatedEvent;
import ru.edu.games.onlinestore.event.OrderEventProducer;

@Component
@Slf4j
@RequiredArgsConstructor
public class NotificationConsumer {


    @RetryableTopic(
            attempts = "3",
            backOff = @BackOff(delay = 2000, multiplier = 2.0),
            dltStrategy = DltStrategy.FAIL_ON_ERROR
    )

    @KafkaListener(topics = OrderEventProducer.ORDER_CREATED_TOPIC, groupId = "online-store-group")
    public void handleOrderCreated(OrderCreatedEvent event){
        log.info("Received OrderCreatedEvent: orderId = {}, userEmail = {}, amount = {}, itemsCount = {}",
                event.getOrderId(), event.getUserEmail(), event.getTotalPrice(), event.getItemCount());

        processNotification(event);

        log.info("Successfully processed notification for orderId={}", event.getOrderId());
    }

    private void processNotification(OrderCreatedEvent event){
        log.info("Sending reciept to customer: email = {}, orderId = {}, amount = {}",
                event.getUserEmail(), event.getOrderId(), event.getTotalPrice());
    }

    @DltHandler
    public void handleDltMessage(OrderCreatedEvent event){

        log.error("CRITICAL: Message went to DLT! Order processing permanently failed for orderId = {}", event.getOrderId());

    }

}
