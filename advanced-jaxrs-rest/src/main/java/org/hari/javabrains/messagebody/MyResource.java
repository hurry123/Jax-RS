package org.hari.javabrains.messagebody;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("messagebodyex")
public class MyResource {

	/*@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Date test(){
		return Calendar.getInstance().getTime();
	}*/
	
	@GET
	@Produces(value = {MediaType.TEXT_PLAIN, "text/shortdate"})
	public Date testMethod(){
		return Calendar.getInstance().getTime();
	}
}
