package com.tenco.demo._domain.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tenco.demo._domain.blog.entity.Article;

// C R U D
// @Repository <- 생략 가능하다. (상속한 JpaRepository에 어노테이션이 존재하므로)
public interface PostRepository extends JpaRepository<Article, Integer>{
	// 기본적인 CRUD 기능을 자동 제공한다.

	// 필요 시, 만들어 놓은 곳에 추가적인 쿼리나 메서드 정의가 가능하다.
}
