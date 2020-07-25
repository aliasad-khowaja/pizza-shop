package org.pizzashop.rest.service;

import org.pizzashop.rest.dao.OrderDao;
import org.pizzashop.rest.model.Order;

import java.util.List;

public class OrderService {

    private final OrderDao orderDao;

    public OrderService() {
        System.out.println("=== OrderService init ===");
        orderDao = new OrderDao();
    }

    public List<Order> getOrders() {
        return orderDao.getOrders();
    }

}
