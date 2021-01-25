package lk.ijse.hibernate.dto;

public class ItemDTO {
    private String itemID;
    private String description;
    private String unitPrice;
    private String qty;

    public ItemDTO(String itemID, String description, String unitPrice, String qty) {
        this.itemID = itemID;
        this.description = description;
        this.unitPrice = unitPrice;
        this.qty = qty;
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
