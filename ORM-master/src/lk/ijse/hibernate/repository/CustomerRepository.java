package lk.ijse.hibernate.repository;

import lk.ijse.hibernate.entity.Customer;
import org.hibernate.Session;

public class CustomerRepository {
    public Customer saveCustomer(Customer customer, Session session){
        int id = (int) session.save(customer);
        customer.setCust_id(id);
        return customer;
    }

    public Customer getCustomer(int i, Session session) {
        Customer customer = session.get(Customer.class, i);
        return customer;
    }
}
