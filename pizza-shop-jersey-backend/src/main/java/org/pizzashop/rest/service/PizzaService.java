package org.pizzashop.rest.service;

import org.pizzashop.rest.dao.PizzaDao;
import org.pizzashop.rest.model.Pizza;

import java.util.List;

public class PizzaService {

    private final PizzaDao pizzaDao;

    public PizzaService() {
        this.pizzaDao = new PizzaDao();
    }

    public List<Pizza> getAllPizzas() {
        return pizzaDao.getAllPizzas();
    }

    public Pizza getPizza(Long id) {
        return pizzaDao.getPizza(id);
    }

}
