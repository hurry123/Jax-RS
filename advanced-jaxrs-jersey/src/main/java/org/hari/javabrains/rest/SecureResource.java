package org.hari.javabrains.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("secured")
public class SecureResource {

	@GET
	@Path("message")
	@Produces(MediaType.TEXT_PLAIN)
	public String secureTestMethod() {
		return "this is secured";
	}
	
}
