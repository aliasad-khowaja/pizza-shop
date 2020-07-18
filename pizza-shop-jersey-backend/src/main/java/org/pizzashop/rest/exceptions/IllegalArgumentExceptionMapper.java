package org.pizzashop.rest.exceptions;

import org.pizzashop.rest.model.ErrorResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(Response.Status.BAD_REQUEST.getStatusCode(), "Illegal Argument", e.getMessage()))
                .build();
    }

}
