package com.webservice.springboot.domain.posts;

import com.webservice.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

/**
 * @Entity
 * -> 테이블과 링크될 클래스임을 나타냄
 * -> 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍(_)으로 테이블이름을 매칭 ex)SalsesManager.java => sales_manager table
 *
 * @Id
 * -> 헤당 테이블의 PK필드를 나타냄
 *
 * @GeneratedValue
 * -> PK의 생성 규칙을 나타냄
 * -> strategy = GenerationType.IDENTITY: auto_increment
 *
 * @Column
 * -> 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됨
 * -> 사용하는 이유는, 기본값외에 추가로 변경이 필요한 옵션이 있으면 사용
 * -> length:500: 문자열의 경우 VARCHAR(255)가 기본인데, 사이즈를 500으로 늘리고 싶을때
 * -> columnDefinition = "TEXT": 타입을 TEXT로 변경하고 싶을 때
 * -> nullable = false: 해당 필드는 null이면 안됨
 *
 * @Builder
 * -> 해당 클래스의 빌더 패턴 클래스 생성
 * -> 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함, 채워야 할 필드를 명확하게 지정할 수 있다.
 * -> 생성자나 빌더나 생성시점에 값을 채워주는 역할은 똑같다.
 *
 * Entity 클래스에는 절대 Setter 메소드를 만들지 않는다.
 * -> 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가해야한다.
 * */
