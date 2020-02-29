package com.binary.mindset.apiFirst.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ComponentScan(basePackages = "com.binary.mindset.apiFirst")
public class Config {

    @Bean
    public Docket api() {
        final String BASE_PACKAGE = "com.binary.mindset.apiFirst";
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("Api First tutorial")
                        .description("This is the awesome TaskList management Api!")
                        .contact(new Contact("Biinary Mindset", "https://binarymindset.com", ""))
                        .build())
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                // exclude HomeController
                .apis(Predicates.not(RequestHandlerSelectors.basePackage(BASE_PACKAGE + ".swagger")))
                .build();
    }
}
