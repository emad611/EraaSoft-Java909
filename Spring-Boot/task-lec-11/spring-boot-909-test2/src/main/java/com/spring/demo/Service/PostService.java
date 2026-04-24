package com.spring.demo.Service;

import com.spring.demo.dto.PostDto;
import com.spring.demo.dto.UserDto;
import com.spring.demo.dto.postsWithUserDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    PostDto updatePost(Long id,PostDto postDto);
    PostDto getPostById(Long id);
    void removePostById(Long id);
    List<PostDto> getPosts();
    List<postsWithUserDto>getPostsWithUsers();
    postsWithUserDto getPostWithUsersById(Long id);
}
