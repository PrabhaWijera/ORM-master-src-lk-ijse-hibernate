package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cust_id")
    @ToString.Exclude
    private Customer customer;
}
