package com.skcx.order.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class TestTask {

    @Scheduled(cron = "0/5 * * * * *")
    public void scheduled1() throws InterruptedException {
        Thread.sleep(5000);
        log.info("scheduled1 每5秒执行一次：{}", LocalDateTime.now());
    }

}
