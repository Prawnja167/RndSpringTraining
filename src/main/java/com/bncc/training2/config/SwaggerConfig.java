package com.bncc.training2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private static final String CONTROLLER_PATH = "com.bncc.training2.controller";
  private static final String SWAGGER_TITLE = "Training API";
  private static final String SWAGGER_DESCRIPTION = "Documentation of API";
  private static final String SWAGGER_VERSION = "1.0.0";

  @Bean
  ApiInfo apiInfo() {
    return new ApiInfoBuilder().title(SWAGGER_TITLE).description(SWAGGER_DESCRIPTION)
        .version(SWAGGER_VERSION).build();
  }

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage(CONTROLLER_PATH))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(apiInfo());
  }

}
