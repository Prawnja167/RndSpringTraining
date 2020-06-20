package com.bncc.training2.controller;

import com.bncc.training2.dto.response.student.FindStudentByNameResponse;
import com.bncc.training2.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
