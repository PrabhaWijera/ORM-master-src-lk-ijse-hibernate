package lk.ijse.hibernate;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Employee;
import lk.ijse.hibernate.entity.Task;
import lk.ijse.hibernate.entity.Vehicle;
import lk.ijse.hibernate.repository.CustomerRepository;
import lk.ijse.hibernate.repository.VehicleRepository;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Employee employee1 = new Employee();
            employee1.setName("Prabhash");

            Employee employee2 = new Employee();
            employee1.setName("Wijerathna");

            Task task1 = new Task();
            task1.setName("Task 1");

            Task task2 = new Task();
            task1.setName("Task 2");

            employee1.getTasks().add(task1);
            employee1.getTasks().add(task2);
            employee2.getTasks().add(task2);

            task1.getEmployeeList().add(employee1);
            task2.getEmployeeList().add(employee1);
            task2.getEmployeeList().add(employee2);

            session.save(employee1);
            session.save(employee2);
            session.save(task1);
            session.save(task2);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    /*public static void saveCustomer(){
        CustomerRepository customerRepository = new CustomerRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Customer customer = new Customer();
            customer.setName("Nimeth");
            customerRepository.saveCustomer(customer, session);

            List<Vehicle> vehicles = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Vehicle vehicle = new Vehicle();
                vehicle.setType("Type" + (i+1));
                vehicle.setCustomer(customer);
                vehicleRepository.saveVehicle(vehicle, session);
                vehicles.add(vehicle);
            }
            customer.setVehicles(vehicles);
            transaction.commit();

            printVehicle(1);
            printCustomer(1);
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    private static void printCustomer(int i) {
        CustomerRepository customerRepository = new CustomerRepository();
        Session session = FactoryConfiguration.getInstance().getSession();

        Customer customer = customerRepository.getCustomer(i, session);
        System.out.println(customer.toString());
    }

    private static void printVehicle(int i) {
        VehicleRepository vehicleRepository = new VehicleRepository();
        Session session = FactoryConfiguration.getInstance().getSession();

        Vehicle vehicle = vehicleRepository.get(i, session);
        System.out.println(vehicle.toString());
    }
*/

    /*public static void saveStudent(){
        StudentRepository studentRepository = new StudentRepository();
        LaptopRepository laptopRepository = new LaptopRepository();

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Laptop laptop = new Laptop();
            laptop.setBrand("Dell");

            Student student = new Student();
            student.setName("Nimal");
            student.setLaptop(laptop);

            studentRepository.saveStudent(student, session);
            laptopRepository.saveLaptop(laptop, session);

            printStudent(student.getId());
            printLaptop(laptop.getId());

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static void printStudent(int i){
        StudentRepository studentRepository = new StudentRepository();
        Session session = FactoryConfiguration.getInstance().getSession();

        Student student = studentRepository.getStudent(i, session);
        System.out.println(student.toString());
    }

    public static void printLaptop(int i){
        LaptopRepository laptopRepository = new LaptopRepository();
        Session session = FactoryConfiguration.getInstance().getSession();

        Laptop laptop = laptopRepository.get(i, session);
        System.out.println(laptop.toString());
    }*/
}
