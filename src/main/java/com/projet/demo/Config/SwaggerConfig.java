package com.projet.demo.Config;

import static com.projet.demo.Utils.Constants.App_ROOT;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(
				new ApiInfoBuilder()
				.description("gestion d'hotel")
				.title("gestion hotel rest API")						
				.build()
			)
			.groupName("rest API v1")
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.projet.demo"))
			.paths(PathSelectors.ant(App_ROOT+"/**"))
			.build();
		
	}
	
}
