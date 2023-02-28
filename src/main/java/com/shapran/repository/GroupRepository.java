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

public class GroupRepository {
    private static GroupRepository instance;
    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }

    public List<Group> getAll(){
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery("from Group", Group.class)
                .getResultList();
    }

    public List<Group> getGroupByName(String name){
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Group> criteriaQuery = cb.createQuery(Group.class);
        Root<Group> groupRoot = criteriaQuery.from(Group.class);
        criteriaQuery.select(groupRoot);
        Predicate condition = cb.like(cb.lower(groupRoot.get("groupName")), name.toLowerCase() + "%");
        criteriaQuery.where(condition);
        return entityManager.createQuery(criteriaQuery)
                .getResultList();
    }

    public Map<String, Double> getAverageGrade(){
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        final CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createQuery(Tuple.class);
        Root<Group> groupRoot = criteriaQuery.from(Group.class);
        Join<Group,Student>  studentJoin = groupRoot.join("students");
        Join<Student, Grade> gradeJoin = studentJoin.join("grades");
        criteriaQuery.multiselect(groupRoot.get("groupName"), cb.avg(gradeJoin.get("mark")))
                .groupBy(groupRoot.get("groupName"));
        List<Tuple> result = entityManager.createQuery(criteriaQuery)
                .getResultList();
        Map<String,Double> map = new HashMap<>();
        result.forEach(r->map.put((String) r.get(0), (Double) r.get(1)));
        return map;
    }
}
