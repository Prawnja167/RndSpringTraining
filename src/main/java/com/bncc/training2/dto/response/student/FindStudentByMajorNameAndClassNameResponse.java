package com.bncc.training2.dto.response.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindStudentByMajorNameAndClassNameResponse {
  private String studentName;
  private String majorName;
  private String className;
}
