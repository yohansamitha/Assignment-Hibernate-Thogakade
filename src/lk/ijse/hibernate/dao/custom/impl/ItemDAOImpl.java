package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.ItemDAO;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Item item) {
        return false;
    }

    @Override
    public Item search(String s) {
        return null;
    }

    @Override
    public List<Item> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query from_item = session.createQuery("FROM Item");
        List<Item> list = from_item.list();
        transaction.commit();
        session.close();
        return list;
    }
}
