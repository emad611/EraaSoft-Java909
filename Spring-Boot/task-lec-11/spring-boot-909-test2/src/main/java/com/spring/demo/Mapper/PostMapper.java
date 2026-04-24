package com.spring.demo.Mapper;

import com.spring.demo.dto.PostDto;
import com.spring.demo.dto.postsWithUserDto;
import com.spring.demo.model.PostModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
@Mapper(componentModel="spring")
public interface PostMapper {
   PostModel toEntity(PostDto postDto);
   //to slo f.k
    @Mapping(source = "userModel.id", target = "userId")
   PostDto toDto(PostModel postModel);
   List<PostModel>toEntityList(List<PostDto> postDtoList);
  List<PostDto>toDtoList(List<PostModel>postModels);
   postsWithUserDto toPostsWithUsersDto(PostModel postModel);
  List<postsWithUserDto>toPostsWithUsersDtoList(List<PostModel>postModels);
}
