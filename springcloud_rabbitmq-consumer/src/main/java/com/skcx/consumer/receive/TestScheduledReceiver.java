package com.skcx.consumer.receive;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TestScheduledReceiver {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("ScheduledTaskDirectQueue"))//监听的队列名称 ScheduledTaskDirectQueue
    public void process(String testMessage) {
        try {
            Thread.sleep(4000);
            System.out.println("TestScheduledReceiver消费者收到消息  : " + testMessage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


