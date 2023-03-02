package lk.ijse.hibernate.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "student")
@Table(name = "student")
public class Student {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment
    private int id;

    @Column
    private String name;

    @OneToOne()
    @ToString.Exclude
    private Laptop laptop;
}
