package com.skcx.consumer.receive;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TopicTotalReceiver {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("topic.total")) // 会创建队列，再监听
    public void process(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者收到消息  : " + testMessage.toString());
    }


}
