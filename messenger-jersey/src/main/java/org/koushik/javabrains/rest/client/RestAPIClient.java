package org.koushik.javabrains.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.SyncInvoker;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.koushik.javabrains.messenger.model.Message;

public class RestAPIClient {

	public static void main(String args[]){
		


		Client client = ClientBuilder.newClient();
		
		WebTarget baseTarget = client.target("http://localhost:8080/advanced-jaxrs-jersey/webapi/");
		WebTarget messagesTarget = baseTarget.path("messages");
		WebTarget singleMessageTarget = messagesTarget.path("{messageId}");
		
		Message message1 =  singleMessageTarget
				.resolveTemplate("messageId", "1")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);
		
		Message message2 =  singleMessageTarget
				.resolveTemplate("messageId", "2")
				.request(MediaType.APPLICATION_JSON)
				.get(Message.class);

		Message newMessage = new Message(4, "My new message", "Teja");
		
		Response postResponse = messagesTarget
			.request()
			.post(Entity.json(newMessage));
		
	
		Message createdMessage = postResponse.readEntity(Message.class);
		
		System.out.println(createdMessage.getMessage());
		
		
		System.out.println(message1.getMessage());
		System.out.println(message2.getMessage());
		
		//Response response = client.target("http://localhost:8080/advanced-jaxrs-jersey/webapi/messages/1").request().get();
		/*WebTarget target = client.target("http://localhost:8080/advanced-jaxrs-jersey/webapi/messages/2");
		Builder builder = target.request(MediaType.APPLICATION_JSON);
		Message message = builder.get(Message.class);
		//String message1 = client.target("http://localhost:8080/advanced-jaxrs-jersey/webapi/messages/1").request().get(String.class);
		//Message message =response.readEntity(Message.class); 
		System.out.println(message);
		*/
		
		
		
		
	}

}
