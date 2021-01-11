package com.halcyon.file_manage.configurer;

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

		public Docket CreatRestApi() {
			return new Docket(DocumentationType.SWAGGER_2)
					.apiInfo(apiInfo())
					.select()
					// 扫描Swagger作用的包
					.apis(RequestHandlerSelectors.basePackage("com.halcyon.file_manage.web"))
					.paths(PathSelectors.regex("/*"))
					.build();
			
		}

		private ApiInfo apiInfo() {
			return new ApiInfoBuilder()
					.title("SRPING BOOT API RESTFUL ")
					.description("DESCRIPTION")
					.termsOfServiceUrl("http://localhost:8080").version("0.1").build();
			
		}
}
