package com.example.demo.dao;

import com.example.demo.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;
@Repository
public class CustomerDAOImpl implements CustomerDAO{
@Autowired
private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session currentSession=sessionFactory.getCurrentSession();
//        Query<Customer> theQuery=currentSession.createQuery("select firstName from Customer",Customer.class);
        Query<Customer> theQuery=currentSession.createQuery("from Customer", Customer.class);
        List<Customer> customers=theQuery.getResultList();
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        Session currentSession=sessionFactory.getCurrentSession();
               currentSession.saveOrUpdate(theCustomer);

    }

    @Override
    public Customer getCustomer(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();
Customer theCustomer=currentSession.get(Customer.class,theId);
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session currentSession=sessionFactory.getCurrentSession();
     Query theQuery=currentSession.createQuery("delete from Customer where id=:theCustomer");
     theQuery.setParameter("theCustomer",theId);
     theQuery.executeUpdate();
    }
}
