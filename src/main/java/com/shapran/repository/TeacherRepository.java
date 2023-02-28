package com.shapran.repository;

import com.shapran.model.Teacher;
import com.shapran.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class TeacherRepository {
    private static TeacherRepository instance;

    public static TeacherRepository getInstance() {
        if (instance == null) {
            instance = new TeacherRepository();
        }
        return instance;
    }

    public List<Teacher> getTeacherByName(String name) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Teacher> criteriaQuery = cb.createQuery(Teacher.class);
        Root<Teacher> teacherRoot = criteriaQuery.from(Teacher.class);
        criteriaQuery.select(teacherRoot);
        Predicate predicate1 = cb.equal(cb.lower(teacherRoot.get("name")), name.toLowerCase());
        Predicate predicate2 = cb.equal(cb.lower(teacherRoot.get("surname")), name.toLowerCase());
        Predicate predicate = cb.or(predicate1, predicate2);
        criteriaQuery.where(predicate);
        return entityManager.createQuery(criteriaQuery)
                .getResultList();
    }
}
