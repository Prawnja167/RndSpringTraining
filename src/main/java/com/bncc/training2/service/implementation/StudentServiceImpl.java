package com.bncc.training2.service.implementation;

import com.bncc.training2.dto.request.student.FindStudentByFilterRequest;
import com.bncc.training2.dto.response.student.FindStudentByMajorNameAndClassNameResponse;
import com.bncc.training2.dto.response.student.FindStudentByNameResponse;
import com.bncc.training2.entity.Student;
import com.bncc.training2.repository.interfaces.basic.StudentRepo;
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
    List<Student> studentList = studentRepo.findStudentByStudentName(studentName);

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

  @Override
  public List<FindStudentByMajorNameAndClassNameResponse> findStudentByMajorNameAndClassName(String majorName,
      String className) {
    List<Object[]> objectList = studentRepo.findStudentByMajorNameAndClassName(majorName, className);

    return convertObjectToStudentResponse(objectList);
  }

  @Override
  public List<FindStudentByMajorNameAndClassNameResponse> findStudentByFilter(
      FindStudentByFilterRequest request) {
    List<Object[]> objectList = studentRepo.findStudentByFilter(request);

    return convertObjectToStudentResponse(objectList);
  }

  public List<FindStudentByMajorNameAndClassNameResponse> convertObjectToStudentResponse(
      List<Object[]> objectList) {
    List<FindStudentByMajorNameAndClassNameResponse> responseList = new ArrayList<>();

    for(Object[] object : objectList) {
      FindStudentByMajorNameAndClassNameResponse response =
          FindStudentByMajorNameAndClassNameResponse.builder()
          .studentName(object[0].toString())
          .majorName(object[1].toString())
          .className(object[2].toString())
          .build();

      responseList.add(response);
    }

    return responseList;
  }


}
