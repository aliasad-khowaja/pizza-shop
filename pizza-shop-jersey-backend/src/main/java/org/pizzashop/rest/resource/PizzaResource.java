package org.pizzashop.rest.resource;

import org.pizzashop.rest.model.Pizza;
import org.pizzashop.rest.service.PizzaService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.List;

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
