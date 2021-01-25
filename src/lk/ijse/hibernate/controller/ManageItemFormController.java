package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.custom.ItemBO;
import lk.ijse.hibernate.dto.ItemDTO;

public class ManageItemFormController {
    public JFXTextField txtItemID;
    public JFXTextField txtDescription;
    public JFXTextField txtUnitPrice;
    public JFXTextField txtQty;
    public JFXTextField txtSearch;
    public TableView tblCustomer;
    public TableColumn colItemID;
    public TableColumn colDescription;
    public TableColumn colUnitPrice;
    public TableColumn colQtyOnHand;
    ItemBO itemBO = BOFactory.getInstance().getBO(BOFactory.BOType.Item);

    public void btnCreate(ActionEvent actionEvent) {
        ItemDTO itemDTO = new ItemDTO(txtItemID.getText(), txtDescription.getText(), txtUnitPrice.getText(), txtQty.getText());
        try {
            boolean b = itemBO.saveItem(itemDTO);
            if (b) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Customer Saved");
                alert.setContentText("Customer saved successfully!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Something went Wrong!");
            alert.setContentText("Ooops, there was an error!");
            alert.showAndWait();
            e.printStackTrace();
        }
    }

    public void btnUpdate(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void txtSearchOnKeyRelease(KeyEvent keyEvent) {

    }

    public void tblOnMouseRelease(MouseEvent mouseEvent) {

    }
}
