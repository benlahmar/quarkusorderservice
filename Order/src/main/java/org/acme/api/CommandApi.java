package org.acme.api;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.acme.connectors.KafkaProductor;
import org.acme.connectors.OrderDto;
import org.acme.connectors.ProduitClient;
import org.acme.domaine.Command;
import org.acme.domaine.Produit;
import org.acme.service.IService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

@Path("orders")
public class CommandApi {

	
	@Inject
	IService service;
	
	@Inject
	@RestClient
	ProduitClient prdclient;
	
	@Inject
	KafkaProductor producuer;
	
	@POST
	public Response add(Command c)
	{
		System.out.println("sending..........");
		service.addcommand(c);
		//producuer.send("test");
		
		System.out.println("sended..........");
		return Response.ok(c).build();
	}
	
	@GET
	@Path("/{id}")
	public Response find(long id)
	{
		Command c = service.findcmd(id);
		//il faut faire un settter de produit
		
		c.getComposants().forEach(x-> x.setProduit(prdclient.getbyid(x.getIdproduit())));
		System.out.println("..........");
		return Response.ok(c).build();
	}
	
	@Path("/send")
	@POST
	public OrderDto send(OrderDto msg)
	{
		producuer.send(msg);
		return msg;
				
	}
}
