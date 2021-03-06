package org.hari.javabrains.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("date/{dateParam}")
public class DateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getRequestedDate(@PathParam("dateParam") MyDate dateString){
		return "date " + dateString;
	}
	
}
