package org.riva.rest.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.riva.rest.messenger.model.errorMessage;

public class GenericExceptions implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		// TODO Auto-generated method stub
		errorMessage msg = new errorMessage(ex.getMessage(),500,"http://www.abc.xyz");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(msg)
				.build();
	
	}

}
