package com.webservice.springboot.web.dto;

import com.webservice.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}

/**
 * Posts Entity와 거의 비슷한 형태인데 Dto 클래스를 추가한 이유?
 * -> entity 클래스는 데이터 베이스와 맞닿은 핵심 클래스
 * -> 화면 변경은 아주 사소한 기능 변경인데, 이를 위해 테이블과 연결된 Entity 클래스를 변경하는 것은 너무 큰 변경
 * -> Request와 Response용 Dto는 View를 위한 클래스라 정말 자주 변경 필요
 * -> View Layer와 DB Layer의 역할 분리를 철저하게 하는 게 좋음
 * */
