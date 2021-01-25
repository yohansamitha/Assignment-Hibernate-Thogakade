package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item implements SuperEntity {
    @Id
    private String itemID;
    private String description;
    private String unitPrice;
    private String qty;
    @ManyToMany
    private List<Orders> orders;

    public Item(String itemID, String description, String unitPrice, String qty) {
        this.itemID = itemID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
    }

    public Item(String itemID, String description, String unitPrice, String qty, ArrayList<Orders> orders) {
        this.itemID = itemID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.orders = orders;
    }

    public Item() {
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Orders> orders) {
        this.orders = orders;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", description='" + description + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
