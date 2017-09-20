package com.example.openapidemo;

import com.google.common.base.Predicates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackageClasses = {
    PeopleController.class
})
public class SwaggerApiDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SwaggerApiDemoApplication.class, args);
  }

  @Bean
  public Docket personApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .paths(Predicates.not(PathSelectors.regex("/error.*")))
        .build()
        .genericModelSubstitutes(ResponseEntity.class)
        .useDefaultResponseMessages(false)
        .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Open API Demo Docs")
        .description("Lorem ipsum")
        .contact(new Contact("API Owner", "example.com", "api-owner@example.com"))
        .license("Apache License Version 2.0")
        .licenseUrl("https://github.com/springfox/springfox/blob/master/LICENSE")
        .version("1.0")
        .build();
  }
}
