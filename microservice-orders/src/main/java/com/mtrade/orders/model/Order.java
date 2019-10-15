package com.mtrade.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private Integer productId;
    private Date orderDate;
    private Integer quantity;
    private Boolean paidOrder;

    public Order() {
    }

    public Order(int id ,Integer productId, Date orderDate, Integer quantity, Boolean paidOrder) {
        this.id = id;
        this.productId = productId;
        this.orderDate = orderDate;
        this.quantity = quantity;
        this.paidOrder = paidOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getPaidOrder() {
        return paidOrder;
    }

    public void setPaidOrder(Boolean paidOrder) {
        this.paidOrder = paidOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId() &&
                Objects.equals(getProductId(), order.getProductId()) &&
                Objects.equals(getOrderDate(), order.getOrderDate()) &&
                Objects.equals(getQuantity(), order.getQuantity()) &&
                Objects.equals(getPaidOrder(), order.getPaidOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", paidOrder=" + paidOrder +
                '}';
    }
}
