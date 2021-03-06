package org.riva.rest.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;
import javax.xml.crypto.Data;

import org.riva.rest.messenger.database.Database;
import org.riva.rest.messenger.exceptions.DataNotFoundException;
import org.riva.rest.messenger.model.errorMessage;
import org.riva.rest.messenger.model.message;

public class messageService {
	
	public messageService(){
		messages.put(1L, new message(1,"hello paaji","amit R"));
		messages.put(2L, new message(2,"hello worldino","amit Rajawat"));
	}
	
	private Map<Long,message> messages = Database.getMessages();
	
	public List<message> getAllMessages(){
		return new ArrayList<message>(messages.values());
	}
	
	public List<message> getAllMessagesForYear(int year){
		List <message> msgs4yr = new ArrayList<message>();
		Calendar cal = Calendar.getInstance();
		for(message message: messages.values()){
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year){
				msgs4yr.add(message);
			}
		}
		return msgs4yr;
	}
	
	public List<message> getMessagesPaginated(int start,int offset){
		List <message> msgpages = new ArrayList<message>(messages.values());
		return msgpages.subList(start, start+offset);
	}
	
	public message getMessage(long id){
		message message = messages.get(id);
		errorMessage er = new errorMessage("buty",231,"sdgsas");
		Response res = Response.status(Status.FOUND).entity(er).build();
		if(message==null){
			throw new WebApplicationException(res); 
		}
		
		return message;
	}
	public message addMessage(message message){
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;
		
	}
	public message updateMessage(message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(),message);
		return message;
			
	}
	public message deleteMessage(long id){
		return messages.remove(id);
	}
}
