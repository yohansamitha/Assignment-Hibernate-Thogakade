package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.custom.PlaceOrderBO;
import lk.ijse.hibernate.dto.OrderDTO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class PlaceOrderFormController implements Initializable {
    public JFXComboBox<String> cmbCustomerID;
    public JFXTextField txtCustomerName;
    public JFXTextField txtQty;
    public JFXComboBox<String> cmbItemID;
    public Label lblTotal;
    public TableView tblOrderItems;
    public TableColumn<Object, Object> colItemID;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQty;
    List<Customer> allCustomer;
    List<Item> allItem;
    ObservableList<Item> orderedItems = FXCollections.observableArrayList();
    PlaceOrderBO placeOrderBO = BOFactory.getInstance().getBO(BOFactory.BOType.PlaceOrder);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colItemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        getALlItem();
        getAllCustomers();
    }

    private void getAllCustomers() {
        allCustomer = placeOrderBO.getAllCustomer();
        ObservableList<String> allCustomers = FXCollections.observableArrayList();
        for (Customer customer : allCustomer) {
            allCustomers.add(customer.getCusID());
        }
        cmbCustomerID.setItems(allCustomers);
    }

    private void getALlItem() {
        allItem = placeOrderBO.getAllItem();
        ObservableList<String> allItems = FXCollections.observableArrayList();
        for (Item item : allItem) {
            allItems.add(item.getItemID());
        }
        cmbItemID.setItems(allItems);
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) {
        String customerID = cmbCustomerID.getValue();
        String cusName = txtCustomerName.getText();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate now = LocalDate.now();
        System.out.println(dtf.format(now));

        DateTimeFormatter dtff = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime noww = LocalTime.now();
        System.out.println(dtff.format(noww));

        String orderDate = "2021-01-25";
        String orderTime = "04:37:00";
        OrderDTO orderDTO = new OrderDTO(orderDate, orderTime, customerID, orderedItems);
        placeOrderBO.placeOrder(orderDTO);

    }

    public void btnAddItemOnAction(ActionEvent actionEvent) {
        String value = cmbItemID.getValue();
        String qty = "0";
        if (txtQty.getText().isEmpty()) {
            qty = "1";
        } else {
            qty = txtQty.getText();
        }
        for (Item item : allItem) {
            if (item.getItemID().equals(value)) {
                Item item1 = new Item(item.getItemID(), item.getDescription(), item.getUnitPrice(), qty);
                getTotal(qty, item.getUnitPrice());
                orderedItems.add(item1);
                tblOrderItems.setItems(orderedItems);
            }
        }
    }

    private void getTotal(String qty, String unitPrice) {
        int size;
        try {
            size = Integer.parseInt(qty);
        } catch (NumberFormatException e) {
            size = 0;
        }
        double peacePrice = Double.parseDouble(unitPrice);
        double total = Double.parseDouble(lblTotal.getText());
        if (size == 0) {
            lblTotal.setText(String.valueOf(total + peacePrice));
        } else {
            lblTotal.setText(String.valueOf(total + (size * peacePrice)));
        }
    }

    public void cmbCustomerIDOnAction(ActionEvent actionEvent) {
        String custID = cmbCustomerID.getValue();
        for (Customer customer : allCustomer) {
            if (customer.getCusID().equals(custID)) {
                txtCustomerName.setText(customer.getCusName());
            }
        }
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {

    }

    public void tblOnMouseRelease(MouseEvent mouseEvent) {

    }

}
