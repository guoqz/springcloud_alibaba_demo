package com.skcx.provider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Topic Exchange 主题交换机配置
 */
@Configuration
public class TopicRabbitConfig {
    //绑定键
    public final static String man = "topic.man";
    public final static String total = "topic.total";


    // 声明队列1
    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.man, true);
    }

    // 声明队列2
    @Bean
    public Queue secondQueue() {
        return new Queue(TopicRabbitConfig.total, true);
    }


    // 声明主题交换机
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }


    //将 firstQueue 和 topicExchange 绑定,而且绑定的键值为 topic.man
    //这样只要是消息携带的路由键是 topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(man);
    }


    //将 secondQueue 和 topicExchange 绑定,而且绑定的键值为用上通配路由键规则 topic.#
    // 这样只要是消息携带的路由键是以 topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}
