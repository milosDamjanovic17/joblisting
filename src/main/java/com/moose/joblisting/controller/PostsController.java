package com.moose.joblisting.controller;

import com.moose.joblisting.model.Post;
import com.moose.joblisting.repo.PostsRepository;
import com.moose.joblisting.repo.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class PostsController {

    private final PostsRepository postsRepository;
    private final SearchRepository searchRepository;

    @Autowired
    public PostsController(PostsRepository postsRepository, SearchRepository searchRepository){
        this.postsRepository = postsRepository;
        this.searchRepository = searchRepository;
    }

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postsRepository.findAll();
    }

    @GetMapping("/search/{text}")
    public List<Post> search(@PathVariable String text) {

        return searchRepository.findByText(text);
    }

    @PostMapping("/postJob")
    public Post addPost(@RequestBody Post post){

        return postsRepository.save(post);
    }
}
