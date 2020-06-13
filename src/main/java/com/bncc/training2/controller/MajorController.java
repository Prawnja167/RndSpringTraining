package com.bncc.training2.controller;

import com.bncc.training2.dto.request.major.CreateMajorRequest;
import com.bncc.training2.dto.response.major.CreateMajorResponse;
import com.bncc.training2.entity.Major;
import com.bncc.training2.service.interfaces.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/major")
public class MajorController {

  private MajorService majorService;

  @Autowired
  public MajorController(MajorService majorService) {
    this.majorService = majorService;
  }

  //  @GetMapping(value = "/get/{id}")
//  public Major getMajor(@PathVariable String id) {
//    switch (id) {
//      case "1" :
//        return Major.builder().id(1L).name("IPA").description("Ilmu Pengetahuan Alam").build();
//      case "2" :
//        return Major.builder().id(2L).name("IPS").description("Ilmu Pengetahuan Sosial").build();
//      default:
//        return null;
//    }
//  }

//  @GetMapping(value = "/create")
//  public Major createMajor(@RequestParam String id, @RequestParam String name,
//      @RequestParam String description) {
//    return Major.builder().id(Long.valueOf(id)).name(name).description(description).build();
//  }

  @GetMapping(value = "find-major-by-id")
  public Major findMajorById(@RequestParam String id) {
    return majorService.findMajorById(id);
  }

  @GetMapping(value = "find-major-by-name")
  public Major findMajorByName(@RequestParam String majorName) {
    return majorService.findMajorByName(majorName);
  }

  @GetMapping(value = "create-major")
  public Major createMajor(@RequestParam String majorName, @RequestParam String majorDescription) {
    return majorService.createMajor(majorName, majorDescription);
  }

  @GetMapping(value = "update-major-by-id")
  public Major updateMajor(@RequestParam String id, @RequestParam String majorName) {
    return majorService.updateMajorById(id, majorName);
  }

  @PostMapping(value = "create-major-dto")
  public CreateMajorResponse createMajorDTO(@RequestBody CreateMajorRequest request) {
    return majorService.createMajorDTO(request);
  }

  @PostMapping(value = "delete-major-by-id")
  public String deleteMajorById(@RequestParam String id) {
    return majorService.deleteMajor(id);
  }

}
