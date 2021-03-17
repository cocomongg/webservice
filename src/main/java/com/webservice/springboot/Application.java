package com.webservice.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/**
 * @SpirngBootApplication: 스프링 부트의 자동 설정, 스프링Bean읽기, 생성을 모두 자동으로 설정된다.
 * @SpirngBootApplication이 있는 위치부터 설정을 읽어 가기 때문에 이 클래스는 항상 프로젝트의 최상단에 위치해야 한다.
 * main이 실행되면 내장 WAS(Web Application Server)실행
 */
