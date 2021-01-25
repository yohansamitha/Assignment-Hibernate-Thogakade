package lk.ijse.hibernate.dto;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.entity.Item;

import java.sql.Date;
import java.sql.Time;

public class OrderDTO {
    Date orderDate;
    Time orderTime;
    String customerID;
    ObservableList<Item> orderedItems;

    public OrderDTO(String orderDate, String orderTime, String customerID, ObservableList<Item> orderedItems) {
        this.orderDate = Date.valueOf(orderDate);
        this.orderTime = Time.valueOf(orderTime);
        this.customerID = customerID;
        this.orderedItems = orderedItems;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Time getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Time orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public ObservableList<Item> getOrderedItems() {
        return orderedItems;
    }

    public void setOrderedItems(ObservableList<Item> orderedItems) {
        this.orderedItems = orderedItems;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderDate=" + orderDate +
                ", orderTime=" + orderTime +
                ", customerID='" + customerID + '\'' +
                ", orderedItems=" + orderedItems +
                '}';
    }
}
