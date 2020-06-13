package com.bncc.training2.repository.interfaces;

import com.bncc.training2.entity.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepo extends JpaRepository<Major, Long> {
  Major findMajorByMajorName(@Param("major_name") String majorName);
}
