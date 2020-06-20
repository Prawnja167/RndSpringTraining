package com.bncc.training2.service.implementation;

import com.bncc.training2.dto.request.major.CreateMajorRequest;
import com.bncc.training2.dto.response.major.CreateMajorResponse;
import com.bncc.training2.entity.Major;
import com.bncc.training2.repository.interfaces.basic.MajorRepo;
import com.bncc.training2.service.interfaces.MajorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorServiceImpl implements MajorService {

  private MajorRepo majorRepo;

  @Autowired
  public MajorServiceImpl(MajorRepo majorRepo) {
    this.majorRepo = majorRepo;
  }

  @Override
  public Major findMajorById(String id) {
    return majorRepo.findById(Long.valueOf(id)).orElse(new Major());
  }

  @Override
  public Major findMajorByName(String name) {
    return majorRepo.findMajorByMajorName(name);
  }

  @Override
  public Major createMajor(String majorName, String majorDescription) {
    Major major = Major.builder().majorName(majorName).majorDescription(majorDescription).build();
    return majorRepo.save(major);
  }

  @Override
  public CreateMajorResponse createMajorDTO(CreateMajorRequest request) {
    Major major = Major.builder().majorName(request.getMajorName())
        .majorDescription(request.getMajorDescription()).build();
    major = majorRepo.save(major);

    return CreateMajorResponse.builder().id(major.getId())
        .majorName(major.getMajorName())
        .majorDescription(major.getMajorDescription())
        .isDTO(true)
        .build();
  }

  @Override
  public Major updateMajorById(String id, String majorName) {
    Major major = majorRepo.findById(Long.valueOf(id)).orElse(new Major());
    major.setMajorName(majorName);

    major = majorRepo.save(major);
    return major;
  }

  @Override
  public String deleteMajor(String majorId) {
    String response = "";

    try {
      Major major = this.findMajorById(majorId);
      majorRepo.delete(major);

      response = "Success delete Major with id " + majorId;
    } catch (Exception e) {
      response = e.getMessage();
    }

    return response;
  }


}
