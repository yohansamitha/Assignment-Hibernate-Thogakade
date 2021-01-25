package lk.ijse.hibernate.dao.custom.impl;

import lk.ijse.hibernate.dao.custom.CustomerDAO;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public Customer search(String s) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query from_customer = session.createQuery("FROM Customer");
        List<Customer> list = from_customer.list();

        transaction.commit();
        session.close();
        return list;
    }
}
