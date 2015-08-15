package org.riva.rest.messenger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.riva.rest.messenger.model.errorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		errorMessage msg = new errorMessage(ex.getMessage(),404,"http://www.abc.xyz");
		return Response.status(Status.NOT_FOUND)
				.entity(msg)
				.build();
	}

}
