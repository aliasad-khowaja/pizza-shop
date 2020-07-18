package org.pizzashop.rest.service;

import org.pizzashop.rest.common.Utility;
import org.pizzashop.rest.dao.PizzaDao;
import org.pizzashop.rest.model.Pizza;

import javax.validation.ValidationException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PizzaService {

    private final PizzaDao pizzaDao;

    public PizzaService() {
        System.out.println("=== PizzaService init ===");
        this.pizzaDao = new PizzaDao();
    }

    public List<Pizza> getAllPizzas() {
        return pizzaDao.getAllPizzas();
    }

    public Pizza getPizza(Long id) {
        Pizza pizza = pizzaDao.getPizza(id);
        if( pizza==null ) {
            throw new NotFoundException("Pizza not found for Id: " + id);
        } else {
            return pizza;
        }
    }

    public long addPizza(Pizza pizza) {
        validate(pizza);
        return pizzaDao.addPizza(pizza);
    }

    public void updatePizza(Pizza pizza) {
        validate(pizza);
        if( !pizzaDao.hasPizza(pizza.getId()) ) {
            throw new NotFoundException("Pizza not found for Id: " + pizza.getId());
        } else {
            pizzaDao.updatePizza(pizza);
        }
    }

    public void deletePizza(long id) {
        if( !pizzaDao.hasPizza(id) ) {
            throw new NotFoundException("Pizza not found for Id: " + id);
        } else {
            pizzaDao.deletePizza(id);
        }
    }

    private void validate(Pizza pizza) {
        if( pizza==null ) {
            throw new IllegalArgumentException("Pizza details are required");
        } else {
            List<String> errors = new ArrayList<>();
            if(Utility.isEmpty(pizza.getName()) ) {
                errors.add("Pizza name is required");
            } else {
                // do nothing
            }
            if(Utility.isEmpty(pizza.getDescription()) ) {
                errors.add("Pizza description is required");
            } else {
                // do nothing
            }
            if(pizza.getPrice()==null) {
                errors.add("Pizza price is required");
            } else {
                // do nothing
            }
            if( !errors.isEmpty() ) {
                throw new ValidationException(errors.toString());
            } else {
                // validated
            }
        }
    }

}
