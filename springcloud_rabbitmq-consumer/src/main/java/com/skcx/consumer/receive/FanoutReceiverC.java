package com.skcx.consumer.receive;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component

public class FanoutReceiverC {
    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("fanout.C"))
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverC消费者收到消息  : " + testMessage.toString());
    }
}
