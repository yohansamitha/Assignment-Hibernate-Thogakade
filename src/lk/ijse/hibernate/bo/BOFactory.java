package lk.ijse.hibernate.bo;

import lk.ijse.hibernate.bo.custom.impl.CustomerBOImpl;
import lk.ijse.hibernate.bo.custom.impl.ItemBOImpl;
import lk.ijse.hibernate.bo.custom.impl.PlaceOrderBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getInstance() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public <T extends SuperBO>T getBO(BOType boType) {
        switch (boType){
            case Customer:
                return (T) new CustomerBOImpl();
            case Item:
                return (T) new ItemBOImpl();
            case PlaceOrder:
                return (T) new PlaceOrderBOImpl();
        }
        return null;
    }

    public enum BOType {
        Customer,
        Item,
        PlaceOrder
    }
}
