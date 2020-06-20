package com.bncc.training2.repository.interfaces.custom;

import com.bncc.training2.dto.request.student.FindStudentByFilterRequest;

import java.util.List;

public interface StudentRepoCustom {
  List<Object[]> findStudentByFilter(FindStudentByFilterRequest request);
}
