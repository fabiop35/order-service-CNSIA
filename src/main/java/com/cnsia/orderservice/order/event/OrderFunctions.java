package com.cnsia.orderservice.order.event;

import java.util.function.Consumer;

import reactor.core.publisher.Flux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cnsia.orderservice.services.OrderService;

@Configuration
public class OrderFunctions {

    private static final Logger log
            = LoggerFactory.getLogger(OrderFunctions.class);

    @Bean
    public Consumer<Flux<OrderDispatchedMessage>> dispatchOrder(OrderService orderService) {
        return flux
                -> orderService.consumeOrderDispatchedEvent(flux)
                        .doOnNext(order -> log.info("The order with id {} is dispatched",
                        order.id())).subscribe();
    }
}
