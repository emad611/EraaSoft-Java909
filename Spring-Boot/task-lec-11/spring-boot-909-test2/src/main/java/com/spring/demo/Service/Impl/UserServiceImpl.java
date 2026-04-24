package com.spring.demo.Service.Impl;

import com.spring.demo.Mapper.UserMapper;
import com.spring.demo.Service.UserService;
import com.spring.demo.dao.UserRepository;
import com.spring.demo.dto.UserDto;
import com.spring.demo.dto.usersWithPostDto;
import com.spring.demo.model.UserModel;
import jakarta.transaction.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
   private UserMapper userMapper;
   private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserMapper userMapper, UserRepository userRepository) {
        this.userMapper = userMapper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) throws SystemException {
        Optional<UserModel>optionalUserModel=userRepository.findUserModelByUserName(userDto.getUserName());
        if(optionalUserModel.isPresent()){
            throw new RuntimeException("username is exist");
        }
        UserModel userModel=userMapper.toEntity(userDto);
        userModel=userRepository.save(userModel);
        return userMapper.toDto(userModel);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        UserModel userModel = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        userModel.setUserName(userDto.getUserName());
        userModel.setPassword(userDto.getPassword());
        userModel.setAge(userDto.getAge());

        userModel = userRepository.save(userModel);

        return userMapper.toDto(userModel);
    }

    @Override
    public UserDto getUserById(Long id) {
        UserModel userModel = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return userMapper.toDto(userModel);
    }

    @Override
    public void removeUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getUsers(List<Long> ids) {
        List<UserModel> userModels = (ids == null || ids.isEmpty())
                ? userRepository.findAll()
                : userRepository.findAllById(ids);
      return userMapper.toDtoList(userModels);
    }

    @Override
    public List<usersWithPostDto> getUsersWithPosts() {
     List<UserModel> userModels=userRepository.findAll();
     return userMapper.toUsersWithPostDtoList(userModels);
    }

    @Override
    public usersWithPostDto getUserWithPosts(Long id) {
        UserModel userModel = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    return userMapper.toUserWithPostsDto(userModel);
    }
}
