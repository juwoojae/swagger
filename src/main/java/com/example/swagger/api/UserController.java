package com.example.swagger.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 3. 엔드 포인트 그룹화 하기
 * 서비스가 가지는 엔드 포인트는 도메인 별로 특징이 있다.
 * 게시글 관련 CRUD, 회원 관련 CRUD 따라서 이런 엔드 포인드를 그룹화 할수 있다.
 *  동일한 @Tag를 각 클래스별로 부여하면 적용된다.
 * @Tag 어노 테이션 사용하기
 */
@Tag(name="User API", description = "유저 도메인 API")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	@GetMapping("/user/{username}")
	public ResponseEntity<?> userGet(
		@PathVariable("username") String username
	) {

		Map<String , Object> resultBody = Map.of(
			"id", "1",
			"username", username
		);

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(new MediaType("application", "json"));

		return new ResponseEntity<>(resultBody, httpHeaders, HttpStatus.OK);
	}
}
