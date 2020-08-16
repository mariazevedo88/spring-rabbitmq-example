package io.github.mariazevedo88.springrabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
 
    // Value is populated with the queue name from "application.properties" file.
    @Value("${rabbitmq.queue}")
    private String queueName;
     
    // Value is populated with the exchange name from "application.properties" file.
    @Value("${rabbitmq.exchange}")
    private String exchange;
     
    // Value is populated with the routing key from "application.properties" file.
    @Value("${rabbitmq.routingkey}")
    private String routingKey;
 
    // @Bean annotation tells that a method produces a bean which is to be managed by the spring container.
    @Bean
    Queue queue() {
        // Creating a queue.
        return new Queue(queueName, Boolean.FALSE);
    }
 
    @Bean
    TopicExchange topicExchange() {
        // Creating a topic exchange.
        return new TopicExchange(exchange);
    }
 
    @Bean
    Binding binding(final Queue queue, final TopicExchange topicExchange) {
        // Binding the queue to the topic with a routing key.
        return BindingBuilder.bind(queue).to(topicExchange).with(routingKey);
    }
}
