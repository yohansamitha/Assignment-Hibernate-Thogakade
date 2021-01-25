package lk.ijse.hibernate.bo.custom;

import lk.ijse.hibernate.bo.SuperBO;
import lk.ijse.hibernate.dto.OrderDTO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;

import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    List<Item> getAllItem();

    List<Customer> getAllCustomer();

    void placeOrder(OrderDTO orderDTO);
}
