package com.bncc.training2.dto.request.major;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMajorRequest {
  String majorName;
  String majorDescription;
}
