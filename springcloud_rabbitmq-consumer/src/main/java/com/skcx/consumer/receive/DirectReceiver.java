package com.skcx.consumer.receive;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class DirectReceiver {

    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
}
