package com.example.demo.envio;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderQueueSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	//representa a fila configurada
	private Queue queue;
	
	public void send (String order) {
		rabbitTemplate.convertAndSend(this.queue.getName(),order);
	}
}
//https://emmanuelneri.com.br/2018/03/07/rabbitmq-no-spring-boot/
