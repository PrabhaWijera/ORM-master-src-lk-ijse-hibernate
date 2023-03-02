package lk.ijse.hibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int emp_id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "emp_task",
            joinColumns = {@JoinColumn(name = "emp_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")}
    )
    List<Task> tasks = new ArrayList<>();
}
