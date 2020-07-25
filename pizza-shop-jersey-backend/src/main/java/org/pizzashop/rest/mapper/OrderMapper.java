package org.pizzashop.rest.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.pizzashop.rest.model.Order;
import org.pizzashop.rest.model.Pizza;

import java.util.List;

public interface OrderMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "created", column = "created"),
            @Result(property = "status", column = "status"),
            @Result(property = "discount", column = "discount"),
            @Result(property = "pizzas", column = "id", javaType = List.class, many=@Many(select="getPizzaByOrder"))
    })
    @Select("select * from `order` order by created desc")
    List<Order> getOrders();

    /*@Results({
            @Result(property = "id", column = "id"),
            @Result(property = "created", column = "created"),
            @Result(property = "status", column = "status"),
            @Result(property = "discount", column = "discount")
    })
    @Select("select * from `order` where status = #{status} order by created desc")
    List<Order> getOrders(int status);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "created", column = "created"),
            @Result(property = "status", column = "status"),
            @Result(property = "discount", column = "discount")
    })
    @Select("select * from `order` where created = #{created}")
    List<Order> getOrders(Date created);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "created", column = "created"),
            @Result(property = "status", column = "status"),
            @Result(property = "discount", column = "discount")
    })
    @Select("select * from `order` where created = #{created} and status = #{status}")
    List<Order> getOrders(Date created, int status);

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "created", column = "created"),
            @Result(property = "status", column = "status"),
            @Result(property = "discount", column = "discount")
    })
    @Select("select * from `order` where created between #{fromDate} and #{toDate} orderBy created desc")
    List<Order> getOrders(Date fromDate, Date toDate);

    @Select("select * from `order` where id = #{id}")
    Order getOrder(int id);*/

    @Select("select * from pizza where id in (select pizzaId from order_pizza where orderId = #{orderId})")
    List<Pizza> getPizzaByOrder(int orderId);

}
