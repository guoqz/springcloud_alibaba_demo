package com.skcx.provider.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Slf4j
public class TestScheduledTask {

    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法

    /**
     * 每 3 秒写入一条消息
     *
     * @throws
     */
    @Scheduled(cron = "0/3 * * * * *")
    public void scheduled() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置日期格式
        String message = df.format(new Date()) + ":    哈哈哈哈哈嗝~";
        rabbitTemplate.convertAndSend("ScheduledTaskDirectExchange", "ScheduledTaskDirectRouting", message.getBytes());
    }

}
