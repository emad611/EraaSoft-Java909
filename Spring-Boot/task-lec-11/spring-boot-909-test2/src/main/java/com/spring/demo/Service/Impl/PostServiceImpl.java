package com.spring.demo.Service.Impl;

import com.spring.demo.Mapper.PostMapper;
import com.spring.demo.Service.PostService;
import com.spring.demo.dao.PostRepository;
import com.spring.demo.dao.UserRepository; // 🔥 أضف ده
import com.spring.demo.dto.PostDto;
import com.spring.demo.dto.postsWithUserDto;
import com.spring.demo.model.PostModel;
import com.spring.demo.model.UserModel; // 🔥 أضف ده
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private PostMapper postMapper;

    @Autowired
    private UserRepository userRepository; // 🔥 أضف ده

    @Autowired
    public PostServiceImpl(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        PostModel postModel = postMapper.toEntity(postDto);

        //خدنا userId من الـ JSON
        //دورنا عليه في database
        UserModel user = userRepository.findById(postDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        //ربطنا الـ Post بالـ User
        //post.user_model_id = user.id
        postModel.setUserModel(user);

        postModel = postRepository.save(postModel);

        return postMapper.toDto(postModel);
    }

    @Override
    public PostDto updatePost(Long id, PostDto postDto) {
        PostModel postModel = postMapper.toEntity(postDto);
        postRepository.save(postModel);
        return postDto;
    }

    @Override
    public PostDto getPostById(Long id) {
        PostModel postModel = postRepository.findById(id).orElse(null);
        return postMapper.toDto(postModel);
    }

    @Override
    public void removePostById(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public List<PostDto> getPosts() {
        List<PostModel> postModel = postRepository.findAll();
        return postMapper.toDtoList(postModel);
    }

    @Override
    public List<postsWithUserDto> getPostsWithUsers() {
        List<PostModel> postModels = postRepository.findAll();
        return postMapper.toPostsWithUsersDtoList(postModels);
    }

    @Override
    public postsWithUserDto getPostWithUsersById(Long id) {
        PostModel postModel = postRepository.findById(id).orElse(null);
        return postMapper.toPostsWithUsersDto(postModel);
    }
}