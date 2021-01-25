package lk.ijse.hibernate.bo.custom.impl;

import javafx.collections.ObservableList;
import lk.ijse.hibernate.bo.custom.PlaceOrderBO;
import lk.ijse.hibernate.dao.DAOFactory;
import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.dto.OrderDTO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Orders;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    ItemDAO itemDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Item);
    CustomerDAO customerDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.Customer);

    @Override
    public List<Item> getAllItem() {
        return itemDAO.getAll();
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerDAO.getAll();
    }

    @Override
    public void placeOrder(OrderDTO orderDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();

//        Creating order item List
        ObservableList<Item> orderedItems = orderDTO.getOrderedItems();
        ArrayList<Item> orderItems = new ArrayList<>(orderedItems);

//        Creatinig customer
        Customer customer = session.load(Customer.class, orderDTO.getCustomerID());

//        Creating Order
        Orders order = new Orders();
        order.setOrderID("O002");
        order.setOrderTime(String.valueOf(orderDTO.getOrderTime()));
        order.setOrderDate(String.valueOf(orderDTO.getOrderDate()));
        order.setCustomer(customer);
        order.setItems(orderItems);

//        creating order list
        ArrayList<Orders> allOrders = new ArrayList<Orders>();
        allOrders.add(order);

//        adding order to item
        for (Item orderItem : orderItems) {
            orderItem.setOrders(allOrders);
        }

        Transaction transaction = session.beginTransaction();

        session.save(order);

        for (Item orderItem : orderItems) {
            session.update(orderItem);
            System.out.println("item save");
        }

        transaction.commit();
        session.close();
    }
}
