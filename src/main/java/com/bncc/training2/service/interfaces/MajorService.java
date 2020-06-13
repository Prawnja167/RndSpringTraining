package com.bncc.training2.service.interfaces;

import com.bncc.training2.dto.request.major.CreateMajorRequest;
import com.bncc.training2.dto.response.major.CreateMajorResponse;
import com.bncc.training2.entity.Major;

public interface MajorService {
  Major findMajorById(String id);

  Major findMajorByName(String name);

  Major createMajor(String majorName, String majorDescription);

  Major updateMajorById(String id, String majorName);

  CreateMajorResponse createMajorDTO(CreateMajorRequest request);

  String deleteMajor(String majorId);
}
