package org.pizzashop.rest.resource;

import org.pizzashop.rest.model.Pizza;
import org.pizzashop.rest.service.PizzaService;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("pizzas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class PizzaResource {

    private PizzaService pizzaService;

    public PizzaResource() {
        this.pizzaService = new PizzaService();
    }

    @GET
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GET
    @Path("/{id}")
    public Pizza getPizza(@PathParam("id") Long id) {
        return pizzaService.getPizza(id);
    }

    @POST
    public void addPizza(Pizza pizza) {

    }

    @PUT
    @Path("/{id}")
    public void updatePizza(@PathParam("id") Long id, Pizza pizza) {

    }

    @DELETE
    @Path("/{id}")
    public void deletePizza(@PathParam("id") Long id) {

    }



}
