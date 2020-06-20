package com.bncc.training2.repository.interfaces;

import com.bncc.training2.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
  @Query(value = "SELECT * FROM student WHERE firstName LIKE 'Daniel' || '%'", nativeQuery = true)
  List<Student> findStudentByStudentName();
}
