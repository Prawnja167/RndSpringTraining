package com.bncc.training2.repository.implementations;

import com.bncc.training2.dto.request.student.FindStudentByFilterRequest;
import com.bncc.training2.repository.interfaces.custom.StudentRepoCustom;
import com.bncc.training2.util.BaseValidator;
import com.bncc.training2.util.QueryHelper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("studentRepoImpl")
public class StudentRepoCustomImpl implements StudentRepoCustom {

  @PersistenceContext
  EntityManager entityManager;

  @Override
  public List<Object[]> findStudentByFilter(FindStudentByFilterRequest request) {
    StringBuilder query = new StringBuilder();
    query.append("SELECT s.firstname AS studentName, ")
        .append("m.major_name AS majorName, ")
        .append("k.name AS className ")
        .append("FROM student s ")
        .append("JOIN major m on s.major_id = m.id ")
        .append("JOIN kelas k on s.student_class_id = k.id ")
        .append("WHERE 1=1 ");

    setFilterQueryFindStudentByFilter(query, request);
    Query finalQuery = entityManager.createNativeQuery(query.toString());
    setParameterQueryFindStudentByFilter(finalQuery, request);

    return finalQuery.getResultList();
  }

  private void setFilterQueryFindStudentByFilter(StringBuilder query,
      FindStudentByFilterRequest request) {
    String studentName = request.getStudentNameFilter();
    if (BaseValidator.isStringValid(studentName)) {
      query.append("AND s.firstname LIKE :studentName ");
    }

    String majorName = request.getMajorNameFilter();
    if (BaseValidator.isStringValid(majorName)) {
      query.append("AND m.major_name LIKE :majorName ");
    }

    String className = request.getClassNameFilter();
    if (BaseValidator.isStringValid(className)) {
      query.append("AND k.name LIKE :className ");
    }
  }

  private void setParameterQueryFindStudentByFilter(Query finalQuery,
      FindStudentByFilterRequest request) {
    String studentName = request.getStudentNameFilter();
    if (BaseValidator.isStringValid(studentName)) {
      finalQuery.setParameter("studentName", QueryHelper.likeAfter(studentName));
    }

    String majorName = request.getMajorNameFilter();
    if (BaseValidator.isStringValid(majorName)) {
      finalQuery.setParameter("majorName", QueryHelper.likeAfter(majorName));
    }

    String className = request.getClassNameFilter();
    if (BaseValidator.isStringValid(className)) {
      finalQuery.setParameter("className", QueryHelper.likeAfter(className));
    }
  }
}
