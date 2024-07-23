package lk.ijse.dep12.jpa.relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lk.ijse.dep12.jpa.relationship.entity.Course;
import lk.ijse.dep12.jpa.relationship.entity.Student;
import lk.ijse.dep12.jpa.relationship.entity.StudentCourse;
import lk.ijse.dep12.jpa.relationship.util.JpaUtil;

import java.sql.Date;
import java.time.LocalDate;

public class ManyToMAnyDemo1 {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
             EntityManager em = emf.createEntityManager()) {
            EntityTransaction tx = em.getTransaction();
            try {
                tx.begin();
                Student st1 = new Student("S005", "kasun", "sampath", "galle", "011-2346542", Date.valueOf("2000-01-23"));
                Student st2 = new Student("S006", "nimal", "kumara", "badulla", "067-2346542", Date.valueOf("1980-01-01"));

                Course cs1 = new Course("C003", "DEP", "6 months");

                StudentCourse studentCourse1 = new StudentCourse(st1, cs1, "admin", Date.valueOf(LocalDate.now()));
                StudentCourse studentCourse2 = new StudentCourse(st2, cs1, "admin", Date.valueOf(LocalDate.now()));

                em.persist(st1);
                em.persist(st2);
                em.persist(cs1);

                em.persist(studentCourse1);
                em.persist(studentCourse2);

                tx.commit();
            } catch (Throwable e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }
}
