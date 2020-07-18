package org.pizzashop.rest.dao;

import org.apache.ibatis.session.SqlSession;
import org.pizzashop.rest.mapper.PizzaMapper;
import org.pizzashop.rest.model.Pizza;

import java.util.List;

public class PizzaDao {

    public PizzaDao() {
        System.out.println("=== PizzaDao init ===");
    }

    public List<Pizza> getAllPizzas() {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        List<Pizza> pizzas = mapper.getAllPizzas();
        session.commit();
        session.close();
        return pizzas;
    }

    public Pizza getPizza(long id) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        Pizza pizza = mapper.getPizza(id);
        session.commit();
        session.close();
        return pizza;
    }

    public long countPizzas() {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        long count = mapper.countPizzas();
        session.commit();
        session.close();
        return count;
    }

    public boolean hasPizza(long id) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        boolean hasPizza  = mapper.hasPizzaById(id)==1;
        session.commit();
        session.close();
        return hasPizza;
    }

    public long addPizza(Pizza pizza) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        mapper.addPizza(pizza);
        session.commit();
        session.close();
        return pizza.getId();
    }

    public void updatePizza(Pizza pizza) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        mapper.updatePizza(pizza);
        session.commit();
        session.close();
    }

    public void deletePizza(long id) {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        PizzaMapper mapper = session.getMapper(PizzaMapper.class);
        mapper.deletePizza(id);
        session.commit();
        session.close();
    }

}
