package de.jonashackt.springboot2exe.configuration;

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
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/springboot2exe/*"))
				.build();
	}
	
	private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot to Windows exe")
                .description("Simple REST Service just for Demo purposes to show how to create a exe from a Spring Boot app")
                .termsOfServiceUrl("http://springfox.io")
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/jonashackt/springboot2exe/blob/master/LICENSE")
                .version("2.0")
                .build();
    }
}
