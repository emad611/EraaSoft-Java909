package com.spring.demo.controller;

import com.spring.demo.Service.PostService;
import com.spring.demo.dto.PostDto;
import com.spring.demo.dto.postsWithUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService postService;
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> createPost(@RequestBody @Valid PostDto postDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/api/posts")).body(postService.createPost(postDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable Long id, @RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(id,postDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostById(id)) ;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePostById(@PathVariable Long id){
         postService.removePostById(id);
         return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<List<PostDto>>getPosts(){
        return ResponseEntity.ok(postService.getPosts());
    }
    @GetMapping("/user")
    public ResponseEntity<List<postsWithUserDto>>getPostsWithUsers(){
        return ResponseEntity.ok(postService.getPostsWithUsers()) ;
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<postsWithUserDto> getPostWithUsersById(@PathVariable Long id){
        return ResponseEntity.ok(postService.getPostWithUsersById(id));
    }
}
