package org.pizzashop.rest.exceptions;

import org.pizzashop.rest.model.ErrorResponse;

import javax.validation.ValidationException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException e) {
        return Response
                .status(Response.Status.NOT_FOUND)
                .entity(new ErrorResponse(Response.Status.NOT_FOUND.getStatusCode(), "Not Found", e.getMessage()))
                .build();
    }

}
