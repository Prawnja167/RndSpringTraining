package com.bncc.training2.service.interfaces;

import com.bncc.training2.dto.response.student.FindStudentByNameResponse;

import java.util.List;

public interface StudentService {
  List<FindStudentByNameResponse> findStudentByName(String studentName);
}
