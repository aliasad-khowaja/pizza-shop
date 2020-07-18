package org.pizzashop.rest.exceptions;

import org.pizzashop.rest.model.ErrorResponse;

import javax.validation.ValidationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException e) {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(new ErrorResponse(Response.Status.BAD_REQUEST.getStatusCode(), "Validation Error", e.getMessage()))
                .build();
    }

}
