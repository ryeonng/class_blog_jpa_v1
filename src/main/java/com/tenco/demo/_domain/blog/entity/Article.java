package com.tenco.demo._domain.blog.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity 클래스 설계 시 주의사항 - 반드시 기본 생성자가 있어야 한다. (@NoArgsConstructor 추가)
@Entity(name = "tb_article")
@NoArgsConstructor
@Data
public class Article {

	// 특정한 생성자에만 빌더 패턴을 추가할 수 있다.
	@Builder
	public Article(String title, String content) {
		this.title = title;
		this.content = content;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 연결되어 있는 pk를 db로 위임한다.
	@Column(name = "id", updatable = false) // 컬럼명 지정, 수정 못하게 제약 설정
	private Long id;
	
	@Column(name = "title", nullable = false) // not null로 설정
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;
	
}
