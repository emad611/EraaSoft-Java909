package com.spring.demo.Service;

import com.spring.demo.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id,UserDto userDto);
    void deleteUser(Long id);
    List<UserDto> getUsers();
    UserDto getUserById(Long id);
}
