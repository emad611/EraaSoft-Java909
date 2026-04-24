package com.spring.demo.Service;

import com.spring.demo.dto.PostDto;
import com.spring.demo.dto.UserDto;
import com.spring.demo.dto.usersWithPostDto;
import jakarta.transaction.SystemException;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto) throws SystemException;
    UserDto updateUser(Long id,UserDto userDto);
    UserDto getUserById(Long id);
    void removeUserById(Long id);
    List<UserDto>getUsers(List<Long> ids);
    List<usersWithPostDto> getUsersWithPosts();
    usersWithPostDto getUserWithPosts(Long id);
}
