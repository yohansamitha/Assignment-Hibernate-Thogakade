package lk.ijse.hibernate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DashBoardFormController {
    public AnchorPane root;

    public void btnManageCustomerOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageCustomerForm.fxml")));
    }

    public void btnManageItemOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/ManageItemForm.fxml")));
    }

    public void btnPlaceOrderOnAction(ActionEvent actionEvent) throws IOException {
        root.getChildren().clear();
        root.getChildren().add(FXMLLoader.load(this.getClass().getResource("../view/PlaceOrderForm.fxml")));
    }
}
