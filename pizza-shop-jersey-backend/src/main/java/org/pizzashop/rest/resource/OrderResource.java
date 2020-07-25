package org.pizzashop.rest.resource;

import org.pizzashop.rest.service.OrderService;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Singleton
public class OrderResource {

    private final OrderService orderService;

    public OrderResource() {
        System.out.println("=== OrderResource init ===");
        this.orderService = new OrderService();
    }

    @GET
    public Response getAllPizzas() {
        return Response.ok(orderService.getOrders()).build();
    }

}
