package org.pizzashop.rest.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
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
    Pizza getPizza(Long id);

}
