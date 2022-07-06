package org.acme.api;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.acme.connectors.ProduitClient;
import org.acme.domaine.Command;
import org.acme.domaine.Produit;
import org.acme.service.IService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("orders")
public class CommandApi {

	@Inject
	IService service;
	
	@Inject
	@RestClient
	ProduitClient prdclient;
	
	@POST
	
	public Response add(Command c)
	{
		
		service.addcommand(c);
		return Response.ok(c).build();
	}
	
	@GET
	@Path("/{id}")
	public Response find(long id)
	{
		Command c = service.findcmd(id);
		//il faut faire un settter de produit
		
		c.getComposants().forEach(x-> x.setProduit(prdclient.getbyid(x.getIdproduit())));
		
		return Response.ok(c).build();
	}
}
