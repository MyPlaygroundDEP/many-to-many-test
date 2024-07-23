package lk.ijse.dep12.jpa.relationship.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "student_course")
public class StudentCourse implements Serializable {
    @EmbeddedId()
   private StudentCoursePK studentCoursePK;
    @Column(name = "registered_by")
    private String registeredBy;
    private Date date;

    @ManyToOne
    @MapsId("studentId")
    private Student student;

    @ManyToOne
    @MapsId("courseCode")
    private Course course;

    public StudentCourse(StudentCoursePK studentCoursePK, String registeredBy, Date date) {
        this.studentCoursePK = studentCoursePK;
        this.registeredBy = registeredBy;
        this.date = date;
    }

    public StudentCourse( Student student, Course course ,String registeredBy, Date date) {
        this.student =student;
        this.course =course;
        this.studentCoursePK = new StudentCoursePK( course.getCode(),student.getId());
        this.registeredBy = registeredBy;
        this.date = date;
    }
}
