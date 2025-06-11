package ra.web.dao;

import org.springframework.stereotype.Repository;
import ra.web.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDaoImpl {
    @PersistenceContext
    private EntityManager entityManager;
    public List<Student> findAll() {
        String jpql = "FROM Student";
        return entityManager.createQuery(jpql, Student.class).getResultList();
    }

    public void save(Student student){
        entityManager.merge(student);
    }
}
