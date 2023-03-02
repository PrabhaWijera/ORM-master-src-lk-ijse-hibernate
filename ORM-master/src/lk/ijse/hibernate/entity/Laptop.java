package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Laptop {
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private int id;

    @Column
    private String brand;

    @OneToOne(mappedBy = "laptop", targetEntity = Student.class)
    private Student student;
}
