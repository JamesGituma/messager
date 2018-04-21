package com.jamiecode.messager.resources;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.jamiecode.messager.service.MessageService;
import com.jamiecode.messager.model.Message;

import java.util.List;

@Path("messages")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService ms = new MessageService();
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON)
		//if a get request has this as the path, messages?year=2015, this method is still called.
				//to support this kind of query, we can get hold of this query parameter, and return based on what value is inserted for the query parameter.
	public List<Message> getMessages(@QueryParam("year" /*Takes in the name of the query parameter*/) int year ,/*this method will take the value of the query parameter, and pass it as a this method's parameter*/
																	@QueryParam("start") int start,
																	@QueryParam("size") int size) {//This is the method that gets all the messages
			/*if the path is, messages, then the year will be 0*/
		if(year>0) {
			return ms.getAllMessagesForYear(year);
		}
		if(start >=0 && size>0) {
			return ms.getAllMessagesPaginated(start, size);
		}
		return ms.getAllMessages();//if year is 0, this method is called
	}
	
	
	@GET
	@Path("message/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("id") Long id) {
		return ms.getMessage(id);
				
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)//you dont have to repeat this annotations if every method produces or consumes json
	@Produces(MediaType.APPLICATION_JSON)	//you can just put them before the class
		
	public Response addMessage(Message message) {
			//here we are changing the default response code of 200 OK to 201 CREATED
		return Response.status(Status.CREATED)
				.entity(ms.addMessage(message))
				.build();
	}
	
	@PUT
	@Path("message/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("id") Long id,  Message message) {
		message.setId(id);
		return ms.updateMessage(message);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("message/{id}")
	public void deleteMessage(@PathParam("id") Long id) {
		ms.removeMessage(id);
	}
}
