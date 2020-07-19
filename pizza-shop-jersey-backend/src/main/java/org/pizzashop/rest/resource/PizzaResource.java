package org.pizzashop.rest.resource;

import io.swagger.annotations.Api;
import org.pizzashop.rest.model.Pizza;
import org.pizzashop.rest.service.PizzaService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

@Api("Pizza Resource")
@Path("pizzas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class PizzaResource {

    private final PizzaService pizzaService;

    public PizzaResource() {
        System.out.println("=== PizzaResource init ===");
        this.pizzaService = new PizzaService();
    }

    @GET
    public Response getAllPizzas() {
        return Response.ok(pizzaService.getAllPizzas()).build();
    }

    @GET
    @Path("/{id}")
    public Response getPizza(@PathParam("id") long id) {
        return Response.ok(pizzaService.getPizza(id)).build();
    }

    @POST
    public Response addPizza(Pizza pizza, @Context UriInfo uriInfo) {
        long id = pizzaService.addPizza(pizza);
        return Response.created( getUri(uriInfo, id) ).build();
    }

    @PUT
    public Response updatePizza(Pizza pizza) {
        pizzaService.updatePizza(pizza);
        return Response.noContent().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletePizza(@PathParam("id") long id) {
        pizzaService.deletePizza(id);
        return Response.noContent().build();
    }

    private URI getUri(UriInfo uriInfo, long id) {
        return uriInfo.getBaseUriBuilder().path("pizzas").path("/"+id).build();
    }


}
