package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    private String id;
    private String name;
    private String address;
    private String contact;
    private Date dob;

    public Student(String id, String firstName,String lastName, String address, String contact, Date dob) {
        this.id = id;
        this.name = firstName +  " "+lastName ;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
    }
}
