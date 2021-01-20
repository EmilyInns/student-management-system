package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Subject addStudent(Long id, Long studentId) {
        var subject = entityManager.find(Subject.class, id);
        var student = entityManager.find(Student.class, studentId);
        student.addSubject(subject);
        entityManager.merge(subject);
        return subject;
    }

    @Transactional
    public Subject addTeacher(Long id, Long teacherId) {
        var subject = entityManager.find(Subject.class, id);
        var teacher = entityManager.find(Teacher.class, teacherId);
        teacher.addSubject(subject);
        entityManager.merge(subject);
        return subject;
    }

    @Transactional
    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }

    public List<Subject> getAllSubjects() {
        return entityManager.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

}
