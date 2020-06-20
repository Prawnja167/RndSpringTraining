package com.bncc.training2.dto.response.student;

import com.bncc.training2.entity.Major;
import com.bncc.training2.entity.StudentClass;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindStudentByNameResponse {
  private String studentName;
  private Major studentMajor;
  private StudentClass studentClass;
}
