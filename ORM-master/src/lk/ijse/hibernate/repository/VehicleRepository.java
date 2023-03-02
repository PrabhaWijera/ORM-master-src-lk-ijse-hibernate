package lk.ijse.hibernate.repository;

import lk.ijse.hibernate.entity.Laptop;
import lk.ijse.hibernate.entity.Vehicle;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

public class VehicleRepository {
    public Vehicle saveVehicle(Vehicle vehicle, Session session){
        int id = (int) session.save(vehicle);
        vehicle.setId(id);
        return vehicle;
    }

    public Vehicle get(int i, Session session) {
        return session.get(Vehicle.class, i);
    }
}
