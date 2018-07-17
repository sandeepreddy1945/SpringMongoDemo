/**
 * 
 */
package com.app.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.SwaggerDefinition;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sandeep
 *
 */
@EnableSwagger2
@SwaggerDefinition
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any()).build().apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Mongo DB Demo Application")
                .description("A sample Application to Test Rest End Points.")
                .termsOfServiceUrl("https://www.example.com/api")
                .contact(new Contact("Developers", "Yet To Build This URL", "")).license("MIT")
                .licenseUrl("\"https://www.apache.org/licenses/LICENSE-2.0").version("1.0.0").build();

    }
}
