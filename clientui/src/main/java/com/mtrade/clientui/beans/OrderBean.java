package com.mtrade.clientui.beans;

import java.util.Date;

public class OrderBean {

    private int id;
    private Integer productId;
    private Date orderDate;
    private Integer quantity;
    private Boolean paidOrder;

    public OrderBean() {
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
}

