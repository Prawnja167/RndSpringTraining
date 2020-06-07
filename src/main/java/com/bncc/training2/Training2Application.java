package com.bncc.training2;

import com.bncc.training2.entity.Major;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class Training2Application {

	public static void main(String[] args) {
		String MAJOR_NAME = "IPA";
		String MAJOR_DESCRIPTION = "Ilmu Pengetahuan Alam";
		SpringApplication.run(Training2Application.class, args);

		Major major = Major.builder().id(1L).name(MAJOR_NAME).description(MAJOR_DESCRIPTION).build();
	}

}
