package lk.ijse.hibernate.dao;

import lk.ijse.hibernate.dao.custom.impl.CustomerDAOImpl;
import lk.ijse.hibernate.dao.custom.impl.ItemDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case Customer:
                return (T) new CustomerDAOImpl();
            case Item:
                return (T) new ItemDAOImpl();
        }
        return null;
    }

    public enum DAOTypes {
        Customer,
        Item
    }
}
