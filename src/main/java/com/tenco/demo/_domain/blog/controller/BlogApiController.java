package com.tenco.demo._domain.blog.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.demo._domain.blog.dto.ArticleDTO;
import com.tenco.demo._domain.blog.entity.Article;
import com.tenco.demo._domain.blog.service.BlogService;
import com.tenco.demo.common.ApiUtil;
import com.tenco.demo.common.errors.Exception400;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController // @Controller + @ResponseBody
public class BlogApiController {
	
	private final BlogService blogService;
	
	// URL 매핑 : 주소설계 - http://localhost:8080/api/articles
	@PostMapping("/api/articles")
	public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO dto) {
		// 1. 인증 검사
		// 2. 유효성 검사
		Article savedArticle = blogService.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
	}
	
	// 주소설계 - http://localhost:8080/api/articles
	@GetMapping(value = "/api/articles", produces = MediaType.APPLICATION_JSON_VALUE)
	public ApiUtil<?> getAllArticles() {
		List<Article> articles = blogService.findAll();
		if(articles.isEmpty()) {
			//return new ApiUtil<>(new Exception400("게시글이 존재하지 않습니다."));
			throw new Exception400("게시글이 존재하지 않습니다.");
		}
		return new ApiUtil<>(articles);
	}
	
	// 주소설계 - http://localhost:8080/api/articles/1
	@GetMapping(value = "/api/articles/{id}")
	public ApiUtil<?> findArticle(@PathVariable(name = "id") Integer id) {
		// 1. 유효성 검사 생략
		Article article = blogService.findById(id);
		return new ApiUtil<>(article);
	}
}
