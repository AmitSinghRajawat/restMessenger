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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.riva.rest.messenger.model.message;
import org.riva.rest.messenger.service.messageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value333 ={MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class messageResource {
	
	messageService mservice = new messageService();
	@GET
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
	@Path("/{msgId}")
	public message getMessage(@PathParam("msgId") long msgId, @Context UriInfo uinfo){
		message msg =  mservice.getMessage(msgId);
		String uri = getUriForRel(msgId, uinfo);
		msg.addLinks(uri, "self");
		uri = getUriForProfile(msgId,uinfo);
		msg.addLinks(uri, "profile");
		return msg;
	}

	private String getUriForProfile(long msgId,UriInfo uinfo){
		String name = mservice.getMessage(msgId).getAuthor();
		String uri = uinfo
				.getBaseUriBuilder()
				.path(profileResource.class)
				.path(name)
				.build()
				.toString();
		return uri;
	}
	private String getUriForRel(long msgId, UriInfo uinfo) {
		String uri = uinfo
		.getBaseUriBuilder()
		.path(messageResource.class)
		.path(Long.toString(msgId))
		.build()
		.toString();
		return uri;
	}
	
	@POST
	public message addMessages(message message){
		return mservice.addMessage(message);
	}
	
	@PUT
	@Path("/{msgId}")
	public message updateMessages(@PathParam("msgId") long msgId,message message){
		message.setId(msgId);
		return mservice.updateMessage(message);
	}
	
	@DELETE
	@Path("/{msgId}")
	public void deleteMessages(@PathParam("msgId") long msgId){
		mservice.deleteMessage(msgId);
	}
}
