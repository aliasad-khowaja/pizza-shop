package org.pizzashop.rest.dao;

import org.apache.ibatis.session.SqlSession;
import org.pizzashop.rest.mapper.PizzaMapper;
import org.pizzashop.rest.model.Pizza;

import java.util.List;

public class PizzaDao {

    public List<Pizza> getAllPizzas() {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        List<Pizza> pizzas = mapper.getAllPizzas();
        session.commit();
        session.close();
        return pizzas;
    }

    public Pizza getPizza(Long id) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        Pizza pizza = mapper.getPizza(id);
        session.commit();
        session.close();
        return pizza;
    }

}
