package org.pizzashop.rest.model;

import java.util.Date;
import java.util.List;

public class Order {

    private Long id;
    private Date created;
    private Integer status;
    private Double discount;
    private List<Pizza> pizzas;

    public Order() {
    }

    public Order(Long id, Date created, Integer status, Double discount, List<Pizza> pizzas) {
        this.id = id;
        this.created = created;
        this.status = status;
        this.discount = discount;
        this.pizzas = pizzas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", created=" + created +
                ", status=" + status +
                '}';
    }
}
