package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Entity
public class Customer implements SuperEntity {
    @Id
    private String cusID;
    private String cusName;
    private String cusAddress;
    private Date dateOfBirth;
    @OneToMany(mappedBy = "customer")
    private List<Orders> orders;

    public Customer(String cusID, String cusName, String cusAddress, Date dateOfBirth) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.dateOfBirth = dateOfBirth;
    }

    public Customer(String cusID, String cusName, String cusAddress, Date dateOfBirth, List<Orders> orders) {
        this.cusID = cusID;
        this.cusName = cusName;
        this.cusAddress = cusAddress;
        this.dateOfBirth = dateOfBirth;
        this.orders = orders;
    }

    public Customer() {
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getCusID() {
        return cusID;
    }

    public void setCusID(String cusID) {
        this.cusID = cusID;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusAddress() {
        return cusAddress;
    }

    public void setCusAddress(String cusAddress) {
        this.cusAddress = cusAddress;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


}
