package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
    public class TeacherService {

        @PersistenceContext
        EntityManager entityManager;

        public Teacher createTeacher(Teacher teacher) {
            entityManager.persist(teacher);
            return teacher;
        }

        public List<Teacher> getAllTeachers() {
            return entityManager.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
        }

        public Set<Student> getStudentsForSubject(String subjectName, String teacherName) {
            Subject subject = (Subject) entityManager
                    .createQuery("SELECT DISTINCT i FROM Subject i " +
                            "INNER JOIN i.teacher t " +
                            "INNER JOIN i.students s " +
                            "WHERE t.name = :teacherName " +
                            "AND i.subject = :subjectName")
                    .setParameter("teacherName", teacherName)
                    .setParameter("subjectName", subjectName)
                    .getSingleResult();
            Set<Student> students = subject.getStudents();
            return students;
        }
}
