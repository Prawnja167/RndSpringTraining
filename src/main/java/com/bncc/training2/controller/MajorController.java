package com.bncc.training2.controller;

import com.bncc.training2.entity.Major;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/major")
public class MajorController {

  @GetMapping(value = "/get/{id}")
  public Major getMajor(@PathVariable String id) {
    switch (id) {
      case "1" :
        return Major.builder().id(1L).name("IPA").description("Ilmu Pengetahuan Alam").build();
      case "2" :
        return Major.builder().id(2L).name("IPS").description("Ilmu Pengetahuan Sosial").build();
      default:
        return null;
    }
  }

  @GetMapping(value = "/create")
  public Major createMajor(@RequestParam String id, @RequestParam String name,
      @RequestParam String description) {
    return Major.builder().id(Long.valueOf(id)).name(name).description(description).build();
  }

}
