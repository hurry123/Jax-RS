package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



public class InvocationExample {  //Handy to deal with num of services. We can just call the invocator & pass the req. object

	public static void main(String[] args) {

		InvocationExample invokation = new InvocationExample();
		Invocation invoke = invokation.getMessageRequestByYear(2015);
		Response response = invoke.invoke();
		System.out.println(response.getStatus());
		
	}
	
	public Invocation getMessageRequestByYear(int year){
		
		Client client = ClientBuilder.newClient();
		
		return client.target("http://localhost:8080/advanced-jaxrs-jersey/webapi/")
			  .path("messages")
			  .queryParam("year", year)
			  .request(MediaType.APPLICATION_JSON)
			  .buildGet();
		
	}

}
