package com.webservice.springboot.web;

import com.webservice.springboot.service.posts.PostsService;
import com.webservice.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    @GetMapping("/")
    public String index(Model model){ //메인 화면
        model.addAttribute("posts", postsService.findAllDesc());
        return "index"; // src/main/resources/templates/index.mustache
    }

    @GetMapping("/posts/save") //저장
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}") //수정
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
