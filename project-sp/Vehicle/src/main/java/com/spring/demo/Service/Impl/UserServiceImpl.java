package com.spring.demo.Service.Impl;

import com.spring.demo.Service.UserService;
import com.spring.demo.dao.UserRepo;
import com.spring.demo.dto.UserDto;
import com.spring.demo.mapper.UserMapper;
import com.spring.demo.model.User;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
   private UserRepo userRepo;
   private UserMapper userMapper;
    @Autowired
    public UserServiceImpl(UserRepo userRepo, UserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setRole("USER");
        User user=userMapper.toEntity(userDto);
        user=userRepo.save(user);
        return userMapper.toDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("user is not found to update"));
        // بنعمل update جزئي بدل ما نكسر البيانات القديمة(like id,role)
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setAddress(userDto.getAddress());

        user=userMapper.toEntity(userDto);

        return userDto;
    }

    @Override
    public void deleteUser(Long id) {
    userRepo.findById(id).orElseThrow(()->new RuntimeException("user is not found to delete "));
    userRepo.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers() {
       List<User>users=userRepo.findAll();
       List<UserDto>usersDto=userMapper.toDtoList(users);
       return usersDto;
    }

    @Override
    public UserDto getUserById(Long id) {
       User user=userRepo.findById(id).orElseThrow(()->new RuntimeException("user is not found by id to get user"));
       UserDto userDto=userMapper.toDto(user);
       return userDto;
    }
}
