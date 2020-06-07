package com.bncc.training2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Major {
  //attribute (isi datanya)
  private Long id;
  private String name;
  private String description;
  //behaviour (method class)
}
