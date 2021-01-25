package lk.ijse.hibernate.dto;

import java.sql.Date;
import java.time.LocalDate;

public class CustomerDTO {
    private String CustomerID;
    private String CustomerName;
    private String CustomerAddress;
    private Date dtpDateOfBirth;

    public CustomerDTO(String CustomerID, String CustomerName, String CustomerAddress, LocalDate dtpDateOfBirth) {
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.CustomerAddress = CustomerAddress;
        this.dtpDateOfBirth = Date.valueOf(dtpDateOfBirth);
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        this.CustomerID = customerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        this.CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.CustomerAddress = customerAddress;
    }

    public Date getDtpDateOfBirth() {
        return dtpDateOfBirth;
    }

    public void setDtpDateOfBirth(Date dtpDateOfBirth) {
        this.dtpDateOfBirth = dtpDateOfBirth;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "txtCustomerID='" + CustomerID + '\'' +
                ", txtCustomerName='" + CustomerName + '\'' +
                ", txtCustomerAddress='" + CustomerAddress + '\'' +
                ", dtpDateOfBirth=" + dtpDateOfBirth +
                '}';
    }
}
