package org.acme.connectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
public class KafkaProductor {

	@Inject
	@Channel("order-out")
	Emitter<OrderDto> emmitter;
	
	public void send(OrderDto dto)
	{
		System.out.println("************");
		emmitter.send(dto);
	}
}
