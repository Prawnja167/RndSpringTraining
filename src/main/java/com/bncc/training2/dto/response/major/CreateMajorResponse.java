package com.bncc.training2.dto.response.major;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMajorResponse {
  Long id;
  String majorName;
  String majorDescription;
  Boolean isDTO;
}
