package com.skcx.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 鉴权
 */
@Slf4j
@Component
public class LoginFilter implements GlobalFilter, Ordered {
    /**
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("执行全局的过滤器");

        // 获取前端请求的参数token   配合前端设置token
        String token = exchange.getRequest().getHeaders().getFirst("token");
        // 判断token是否为空，返回无权访问信息
//        if (token == null || "".equals(token)) {
//            log.info("该用户未登录");
//            // 返回前端未经授权的状态码
//            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
//            // 结束请求
//            return exchange.getResponse().setComplete();
//        }

        // 放行，继续往下执行
        return chain.filter(exchange);
    }

    /**
     * 指定过滤器的执行顺序   返回值越小，执行的优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
