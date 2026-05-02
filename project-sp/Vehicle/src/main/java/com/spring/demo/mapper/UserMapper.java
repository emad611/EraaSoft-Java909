package com.spring.demo.mapper;

import com.spring.demo.dto.UserDto;
import com.spring.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel="spring")
public interface UserMapper {
    @Mapping(target = "password", ignore = true)
    UserDto toDto(User user);
  User toEntity(UserDto userDto);
 List<UserDto> toDtoList(List<User> users);
List<User>toEntityList(List<UserDto>usersDto);
}
