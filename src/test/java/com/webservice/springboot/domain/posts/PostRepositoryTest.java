package com.webservice.springboot.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //h2 데이터베이스 자동으로 실행
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title="테스트 게시글";
        String content="테스트";

        postsRepository.save(Posts.builder()
                            .title(title)
                            .content(content)
                            .author("jungmin")
                            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts post = postsList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getAuthor()).isEqualTo("jungmin");
    }

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());
        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>> createDate="+posts.getCreatedDate()+", modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }
}
/**
 * @After
 * -> Junit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지정
 * -> 보통 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
 * -> 여러 테스트가 동시에 수행되면 h2 데이터베이스에 데이터가 그대로 남아 있어 다음 테스트 수행 시 실패할 수 있음.
 *
 * postsRepository.save
 * -> posts table에 insert/update 쿼리를 실행
 * -> id가 있으면 update, 없으면 insert 쿼리가 실행
 * */