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
    @JoinColumn(name = "student_id",referencedColumnName = "id",insertable = false,updatable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_code",referencedColumnName = "code",insertable = false,updatable = false)
    private Course course;

    public StudentCourse(StudentCoursePK studentCoursePK, String registeredBy, Date date) {
        this.studentCoursePK = studentCoursePK;
        this.registeredBy = registeredBy;
        this.date = date;
    }

    public StudentCourse( Student student, Course course ,String registeredBy, Date date) {
        this.studentCoursePK = new StudentCoursePK( course.getCode(),student.getId());
        this.registeredBy = registeredBy;
        this.date = date;
    }
}
