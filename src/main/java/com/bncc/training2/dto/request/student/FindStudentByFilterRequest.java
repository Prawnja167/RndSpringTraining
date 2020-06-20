package com.bncc.training2.dto.request.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindStudentByFilterRequest {
  private String studentNameFilter;
  private String majorNameFilter;
  private String classNameFilter;
}
