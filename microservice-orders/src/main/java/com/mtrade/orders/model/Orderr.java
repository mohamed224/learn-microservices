package com.mtrade.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
public class Orderr implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private Integer productId;
    private Date orderDate;
    private Integer quantity;
    private Boolean paidOrder;

    public Orderr() {
    }

    public Orderr(int id , Integer productId, Date orderDate, Integer quantity, Boolean paidOrder) {
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
        if (!(o instanceof Orderr)) return false;
        Orderr orderr = (Orderr) o;
        return getId() == orderr.getId() &&
                Objects.equals(getProductId(), orderr.getProductId()) &&
                Objects.equals(getOrderDate(), orderr.getOrderDate()) &&
                Objects.equals(getQuantity(), orderr.getQuantity()) &&
                Objects.equals(getPaidOrder(), orderr.getPaidOrder());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Orderr{" +
                "id=" + id +
                ", productId=" + productId +
                ", orderDate=" + orderDate +
                ", quantity=" + quantity +
                ", paidOrder=" + paidOrder +
                '}';
    }
}
