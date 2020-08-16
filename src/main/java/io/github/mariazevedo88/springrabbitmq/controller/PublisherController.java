package io.github.mariazevedo88.springrabbitmq.controller;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/springrabbitmqapi")
public class PublisherController {
	
    RabbitTemplate rabbitTemplate;
    
    Binding binding;
    
    @Autowired
    public PublisherController(RabbitTemplate rabbitTemplate, Binding binding) {
    	this.rabbitTemplate = rabbitTemplate;
    	this.binding = binding;
    }
 
    @PostMapping(value = "/send")
    @ResponseStatus(code = HttpStatus.OK)
    public String send(@RequestBody final String message) {
        
    	log.info("Sending message to the queue...");
        rabbitTemplate.convertAndSend(binding.getExchange(), binding.getRoutingKey(), message);
        
        log.info("Message sent successfully to the queue, sending back the response to the user...");
        
        return "Message sent successfully to the queue!";
    }

}
