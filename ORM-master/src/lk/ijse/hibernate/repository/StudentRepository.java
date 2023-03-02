package lk.ijse.hibernate.repository;

import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentRepository {
    Session session = new FactoryConfiguration().getSession();

    public Student saveStudent(Student student, Session session){
        int id = (int) session.save(student);
        student.setId(id);
        return student;
    }

    public Student getStudent(int i, Session session) {
        Student student = session.get(Student.class, i);
        return student;
    }
}
