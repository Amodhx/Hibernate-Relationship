package lk.ijse.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    public Student(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Id
    private int id;
    private String name;
    private String address;
    @OneToOne
    private Laptop laptop;

}
