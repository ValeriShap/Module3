package com.shapran.repository;

import com.shapran.model.Grade;
import com.shapran.model.Subject;
import com.shapran.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;

public class SubjectRepository {
    private static SubjectRepository instance;

    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }

    public void getSubjectWithBestOrWorstGrade() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = cb.createTupleQuery();
        Root<Subject> subjectRoot = criteriaQuery.from(Subject.class);
        Join<Subject, Grade> gradeJoin = subjectRoot.join("grades", JoinType.LEFT);
        Expression<Double> avgGrade = cb.avg(gradeJoin.get("mark"));
        criteriaQuery.multiselect(subjectRoot.get("nameOfSubject"), avgGrade);
        criteriaQuery.groupBy(subjectRoot.get("nameOfSubject"));
        criteriaQuery.orderBy(cb.asc(avgGrade));
        List<Tuple> result = entityManager.createQuery(criteriaQuery).getResultList();

        if (result.isEmpty()) {
            System.out.println("Not found.");
            return;
        }
        Tuple best = result.get(result.size() - 1);
        Tuple worst = result.get(0);
        String bestSubject = best.get(subjectRoot.get("nameOfSubject")).toString();
        Double bestGrade = (Double) best.get(avgGrade);
        String worstSubject = worst.get(subjectRoot.get("nameOfSubject")).toString();
        Double worstGrade = (Double) worst.get(avgGrade);

        System.out.println("Subject with best grades: " + bestSubject + ", average grade: " + bestGrade);
        System.out.println("Subject with worst grades: " + worstSubject + ", average grade: " + worstGrade);

    }
}
