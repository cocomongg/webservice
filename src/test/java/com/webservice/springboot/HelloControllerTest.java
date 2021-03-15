package com.webservice.springboot;

import com.webservice.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // Get /hello
                .andExpect(status().isOk()) // mvc.perform 상태 코드 점검(200인지 아닌지)
                .andExpect(content().string(hello)); // mvc.perform 결과 검증, 응답 본문의 내용을 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto")
                        .param("name", name) //API 테스트할 때 사용될 요청 파라미터를 설정, String만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath: Json 응답값을 필드별로 검증할 수 있는 메소드, $를 기준으로 필드명 명시
                .andExpect(jsonPath("$.amount", is(amount)));


    }
}
/**
 * @RunWith(SpringRunner.class): 스프링 부트 테스트와 JUnit 사이에 연결자 역할
 * @WebMvcTest(controllers = HelloController.class)
 * -> 여러 스프링 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션
 * -> 선언할 경우 @Controller, @ControllerAdvice등을 사용할 수 있다.
 * -> @Service, @Repository, @Component등은 사용 불가
 * @Autowired: 스프링이 관리하는 빈을 주입 받는다.
 * MockMvc클래스: 웹API 테스트 시 사용, 스프링 MVC 테스트의 시작점, 이 클래스를 통해 HTTTP Get, Post등에 대한 API 테스트 가능
 */