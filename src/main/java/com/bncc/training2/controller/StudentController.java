package com.bncc.training2.controller;

import com.bncc.training2.dto.request.student.FindStudentByFilterRequest;
import com.bncc.training2.dto.response.student.FindStudentByMajorNameAndClassNameResponse;
import com.bncc.training2.dto.response.student.FindStudentByNameResponse;
import com.bncc.training2.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

  private StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping("/find-student-by-name")
  public List<FindStudentByNameResponse> findStudentByName(@RequestParam String studentName) {
    return studentService.findStudentByName(studentName);
  }

  @GetMapping("/find-student-by-class-name")
  public List<FindStudentByMajorNameAndClassNameResponse> findStudentByMajorNameAndClassName(
      @RequestParam String majorName, @RequestParam String className) {
    return studentService.findStudentByMajorNameAndClassName(majorName, className);
  }

  @PostMapping("/find-student-by-filter")
  public List<FindStudentByMajorNameAndClassNameResponse> findStudentByFilter(
      @RequestBody FindStudentByFilterRequest request) {
    return studentService.findStudentByFilter(request);
  }
}
