package com.baumotte.login_ticketing.endpoints;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.baumotte.login_ticketing.entities.Service;

@Path ("/authService")
public class LoginEP {
	private final Client client;
	
	public LoginEP() {
		this.client = ClientBuilder.newClient();
	}
	
	@POST
	@Path("{any: .*}")
	@Consumes (MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Response doPost(String obj, @Context UriInfo uriInfo) {
		Response r = null;
		
		String[] path = uriInfo.getPath().split("/");
		
		if(path.length < 2) {
			r = Response.status(Response.Status.BAD_REQUEST).build();
		}else {
			String uri = getURL(path[1]);
			for(int i = 2; i < path.length; i++)
				uri += "/" + path[i];
			
			String response = client.target(uri)
					.request()
					.post(Entity.entity(obj, MediaType.APPLICATION_JSON))
					.readEntity(String.class);
			
			r = Response.status(Response.Status.OK).entity(response).build();
		}
		
		return r;
	}
	
	private String getURL(String serviceName) {
		return client.target("http://localhost:8080/servicebroker/rest/servicebroker/" + serviceName)
				.request()
				.accept(MediaType.APPLICATION_JSON)
				.get()
				.readEntity(Service.class)
				.getURL();
	}

}
