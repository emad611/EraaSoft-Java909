package com.spring.demo.Mapper;

import com.spring.demo.dto.UserDto;
import com.spring.demo.dto.usersWithPostDto;
import com.spring.demo.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel="spring")
public interface UserMapper {
   UserModel toEntity(UserDto userDto);
    UserDto toDto(UserModel userModel);
    List<UserModel> toEntityList(List<UserDto> userDtoList);
   List<UserDto> toDtoList(List<UserModel>userModelList);
    usersWithPostDto toUserWithPostsDto(UserModel userModelr);
    List<usersWithPostDto> toUsersWithPostDtoList(List<UserModel> users);
}
