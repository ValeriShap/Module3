package com.shapran.repository;

import com.shapran.model.Grade;
import com.shapran.model.Group;
import com.shapran.model.Student;
import com.shapran.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private static StudentRepository instance;

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public Map<String, Long> numberOfStudentInGroup() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createQuery(Tuple.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        Join<Student, Group> join = studentRoot.join("group", JoinType.INNER);
        criteriaQuery.multiselect(join.get("groupName"), cb.count(studentRoot));
        criteriaQuery.groupBy(join.get("groupName"));
        List<Tuple> tuples = entityManager.createQuery(criteriaQuery)
                .getResultList();
        Map<String, Long> map = new HashMap<>();
        tuples.forEach(t -> map.put((String) t.get(0), (Long) t.get(1)));
        return map;
    }

    public Map<Student, Number> getStudentWithAverageGrade(double grade) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createQuery(Tuple.class);
        Root<Student> studentRoot = criteriaQuery.from(Student.class);
        Join<Student, Grade> join = studentRoot.join("grades", JoinType.LEFT);
        Expression<Number> doubleGrade = join.get("mark");
        criteriaQuery.where(cb.ge(doubleGrade, grade));
        criteriaQuery.select(cb.tuple(studentRoot.get("id"), doubleGrade));
        List<Tuple> tuples = entityManager.createQuery(criteriaQuery)
                .getResultList();
        Map<Student, Number> map = new HashMap<>();
        for (Tuple tuple : tuples) {
            String studentId = (String) tuple.get(0);
            Number avgGrade = (Number) tuple.get(1);
            Student student = entityManager.find(Student.class, studentId);
            if (student != null) {
                map.put(student, avgGrade);
            }
        }
        return map;
    }

}
