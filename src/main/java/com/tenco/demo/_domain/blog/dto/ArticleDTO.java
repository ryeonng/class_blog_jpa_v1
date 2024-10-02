package com.tenco.demo._domain.blog.dto;

import com.tenco.demo._domain.blog.entity.Article;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
// 즉, 주로 계층 간 데이터 전송을 목적으로 설계
public class ArticleDTO {

	private String title;
	private String content;
	
	// 여기서 ArticleDTO -> Article의 데이터 타입을 변환시키는 메서드를 만들었음
	public Article toEntity() {
		return Article.builder()
						.title(this.title)
						.content(this.content)
						.build();
	}
	
}
