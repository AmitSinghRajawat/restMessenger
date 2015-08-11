package org.riva.rest.messenger.messageResource;

import java.util.List;

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

import org.riva.rest.messenger.model.message;
import org.riva.rest.messenger.service.messageService;

@Path("/messages")
public class messageResource {
	
	messageService mservice = new messageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<message> getMessages(@QueryParam("year")int year,
			@QueryParam("start")int start,
			@QueryParam("size")int size){
		if(year>0){
			return mservice.getAllMessagesForYear(year);
		}
		if(start>=0 && size>=0){
			return mservice.getMessagesPaginated(start, size);
		}
		return mservice.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{msgId}")
	public message getMessage(@PathParam("msgId") long msgId){
		return mservice.getMessage(msgId);
	//	return "hi"+msgId;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public message addMessages(message message){
		return mservice.addMessage(message);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{msgId}")
	public message updateMessages(@PathParam("msgId") long msgId,message message){
		message.setId(msgId);
		return mservice.updateMessage(message);
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{msgId}")
	public void deleteMessages(@PathParam("msgId") long msgId){
		mservice.deleteMessage(msgId);
	}
	

}
