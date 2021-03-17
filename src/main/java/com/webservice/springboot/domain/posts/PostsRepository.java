package com.webservice.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}

/**
 * JpaRepository<Entity 클래스, PK 타입>
 * -> 해당 클래스를 상속받으면 기본적인 CRUD메소드가 자동으로 생성
 * -> @Repository 추가할 필요 없음.
 *
 * Entity클래스와 기본 Entity Repository는 함께 위치해야 함, domian 패키지에서 함께 관리하자!
 * */