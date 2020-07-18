package org.pizzashop.rest.mapper;

import org.apache.ibatis.annotations.*;
import org.pizzashop.rest.model.Pizza;

import java.util.List;

public interface PizzaMapper {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price")
    })
    @Select("select * from pizza")
    List<Pizza> getAllPizzas();

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "description", column = "description"),
            @Result(property = "price", column = "price")
    })
    @Select("select * from pizza where id = #{id}")
    Pizza getPizza(long id);

    @Select("select count(*) from pizza where id=#{id}")
    long hasPizzaById(long id);

    @Select("select count(*) from pizza")
    long countPizzas();

    @Insert("insert into pizza (name, description, price) values(#{name}, #{description}, #{price})")
    @Options(useGeneratedKeys=true, keyColumn = "id", keyProperty = "id")
    void addPizza(Pizza pizza);

    @Update("update pizza set name=#{name}, description=#{description}, price=#{price} where id=#{id}")
    void updatePizza(Pizza pizza);

    @Delete("delete from pizza where id=#{id}")
    void deletePizza(long id);

}
