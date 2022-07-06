package org.acme.connectors;


import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.acme.domaine.Produit;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@RegisterRestClient
@Path("catalogues")
public interface ProduitClient {

	
	@GET
	@Path("/{id}")
	public Produit getbyid(@PathParam("id") long id);
	
	
}
