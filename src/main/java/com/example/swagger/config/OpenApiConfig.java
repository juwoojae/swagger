package com.example.swagger.config;

import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

/**
 * OAS 의 설명 설정 클래스
 */
@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI openAPI() {

		return new OpenAPI()
			.info(new Info()
				.title("swagger 학습용 API 목록")
				.description("swagger 시리즈 학습")
				.version("v1.0.0")
			)
			//도메인에 따라 설명을 붙일수가 있다.
			.servers(List.of(
				new Server()
					.url("http://localhost:8080/")
					.description("개발용 서버")
			)); //어떤 도메인을 통해서 배포하고 있는지
	}

	/**
	 * “/api/v1”, “/api/v2”와 같이 버전별 진행하는 방법.
	 * @return
	 */
	@Bean
	public GroupedOpenApi groupedOpenApiV1() {
		return GroupedOpenApi.builder()
			.group("v1")
			.pathsToMatch("/api/v1/**")
			.build();
	}

	@Bean
	public GroupedOpenApi groupedOpenApiV2() {
		return GroupedOpenApi.builder()
			.group("v2")
			.pathsToMatch("/api/v2/**")
			.build();
	}
}

