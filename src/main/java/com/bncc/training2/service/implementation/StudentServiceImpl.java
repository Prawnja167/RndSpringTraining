package com.bncc.training2.service.implementation;

import com.bncc.training2.dto.response.student.FindStudentByNameResponse;
import com.bncc.training2.entity.Student;
import com.bncc.training2.repository.interfaces.StudentRepo;
import com.bncc.training2.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

  private StudentRepo studentRepo;

  @Autowired
  public StudentServiceImpl(StudentRepo studentRepo) {
    this.studentRepo = studentRepo;
  }

  @Override
  public List<FindStudentByNameResponse> findStudentByName(String studentName) {
    List<Student> studentList = studentRepo.findStudentByStudentName();

    return convertStudentToStudentResponse(studentList);
  }

  private List<FindStudentByNameResponse> convertStudentToStudentResponse(List<Student> studentList) {
    List<FindStudentByNameResponse> responseList = new ArrayList<>();

    for (Student student : studentList) {
      String studentName = student.getFirstname() + " " + student.getSurname();
      FindStudentByNameResponse response = FindStudentByNameResponse.builder()
          .studentName(studentName)
          .studentClass(student.getStudentClass())
          .studentMajor(student.getMajor())
          .build();

      responseList.add(response);
    }

    return responseList;
  }
}
