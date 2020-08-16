package io.github.mariazevedo88.springrabbitmq.service;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class SubscriberService {
	
    Queue queue;
	
    @Autowired
	public SubscriberService(Queue queue) {
		this.queue = queue;
	}
 
    @RabbitListener(queues = "#{queue.getName()}")  // Dynamically reading the queue name using SpEL from the "queue" object.
    public void receive(final String message) {
        log.info("Listening messages from the queue!!");
        log.info("Received the following message from the queue= " + message);
        log.info("Message received successfully from the queue.");
    }
}
