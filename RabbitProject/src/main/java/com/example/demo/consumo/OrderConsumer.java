package com.example.demo.consumo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OrderConsumer {

	/*
	 * Por padrão, a anotação @RabbitListener instância apenas um consumer, 
	 * ou seja, não trabalha com concorrência na leitura da fila, 
	 * caso seja necessário mudar esse comportamento, configurar as 
	 * propriedades spring.rabbitmq.listener.simple.concurrency e 
	 * spring.rabbitmq.listener.simple.max-concurrency 
	 * no application.properties.
	 */
	@RabbitListener(queues = {"${queue.order.name"})
	public void receive(@Payload String fileBody) {
		System.out.println("Order : " + fileBody);
	}
}
