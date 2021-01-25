package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import lk.ijse.hibernate.bo.BOFactory;
import lk.ijse.hibernate.bo.custom.CustomerBO;
import lk.ijse.hibernate.dto.CustomerDTO;

public class ManageCustomerFormController {
    public JFXTextField txtCustomerID;
    public JFXTextField txtCustomerName;
    public JFXTextField txtCustomerAddress;
    public JFXDatePicker dtpDateOfBirth;
    public JFXTextField txtSearch;
    public TableView tblCustDetail;
    public TableColumn colCustID;
    public TableColumn colCustName;
    public TableColumn colCustAddress;
    public TableColumn colCustDOB;
    CustomerBO customerBO = BOFactory.getInstance().getBO(BOFactory.BOType.Customer);

    public void btnCreateOnAction(ActionEvent actionEvent) {
        CustomerDTO customerDTO = new CustomerDTO(txtCustomerID.getText(),txtCustomerName.getText(),txtCustomerAddress.getText(),dtpDateOfBirth.getValue());
        try {
            boolean b = customerBO.addCustomer(customerDTO);
            System.out.println(b+" customer add");
            if (b){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Customer Saved");
//                alert.setHeaderText("Look, an Information Dialog");
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

    public void btnUpdateOnAction(ActionEvent actionEvent) {

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {

    }

    public void txtSearchOnKeyRelease(KeyEvent keyEvent) {

    }
}
