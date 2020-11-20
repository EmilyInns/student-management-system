package se.iths.service;

import se.iths.entity.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;

    public Student createStudent(Student student) {
        entityManager.persist(student);
        return student;
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }

    public void deleteStudent(Long id) {
        Student deleteThisStudent = entityManager.find(Student.class, id);
        entityManager.remove(deleteThisStudent);
    }

    public Student findStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student findStudentByLastName(String lastName) {
        return entityManager.find(Student.class, lastName);
    }

    public List<Student> getByLastName(String name) {
        String query = "SELECT i FROM Student i WHERE i.lastname = '" + name + "'";
        return entityManager.createQuery(query, Student.class).getResultList();
    }

    public List<Student> getAllStudents() {
        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

}
