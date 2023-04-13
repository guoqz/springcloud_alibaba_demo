package com.skcx.consumer.receive;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TopicManReceiver {

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue("topic.man")) // 会创建队列，再监听
    public void process(Map testMessage) {
        System.out.println("TopicManReceiver消费者收到消息  : " + testMessage.toString());
    }


}
