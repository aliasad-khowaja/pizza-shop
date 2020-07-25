package org.pizzashop.rest.dao;

import org.apache.ibatis.session.SqlSession;
import org.pizzashop.rest.mapper.OrderMapper;
import org.pizzashop.rest.model.Order;

import java.util.List;

public class OrderDao {

    public OrderDao() {
        System.out.println("=== OrderDao init ===");
    }

    public List<Order> getOrders() {
        SqlSession session = MyBatisUtil.getSessionFactory().openSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> orders = mapper.getOrders();
        session.commit();
        session.close();
        return orders;
    }

}
