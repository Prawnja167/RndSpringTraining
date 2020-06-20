package com.bncc.training2.repository.interfaces.basic;

import com.bncc.training2.entity.Student;
import com.bncc.training2.repository.interfaces.custom.StudentRepoCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>, StudentRepoCustom {
  @Query(value = "SELECT s.firstname FROM student WHERE LOWER(firstName) LIKE LOWER(:firstName) || '%'",
         nativeQuery = true)
  List<Student> findStudentByStudentName(@Param("firstName") String studentName);

  @Query(value = "SELECT s.firstname AS studentName, "
      + "m.major_name AS majorName, "
      + "k.name AS className "
      + "FROM student s "
      + "JOIN major m on s.major_id = m.id "
      + "JOIN kelas k on s.student_class_id = k.id ", nativeQuery = true)
  List<Object[]> findStudentByMajorNameAndClassName(@Param("majorName") String majorName,
      @Param("className") String className);
}
