package lk.ijse.hibernate.repository;

import lk.ijse.hibernate.entity.Laptop;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

public class LaptopRepository {
    Session session = FactoryConfiguration.getInstance().getSession();

    public Laptop saveLaptop(Laptop laptop, Session session){
        int id = (int) session.save(laptop);
        laptop.setId(id);
        return laptop;
    }

    public Laptop get(int i, Session session) {
        return session.get(Laptop.class, i);
    }
}
