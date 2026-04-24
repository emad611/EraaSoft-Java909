package com.spring.demo.controller;

import com.spring.demo.Service.UserService;
import com.spring.demo.dto.UserDto;
import com.spring.demo.dto.usersWithPostDto;
import jakarta.transaction.SystemException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto userDto) throws SystemException, URISyntaxException {
        return ResponseEntity.created(new URI("api/users/save")).body(userService.createUser(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Long id,
                              @RequestBody @Valid UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id,userDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable @Valid Long id) {
        return ResponseEntity.ok( userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeUserById(@PathVariable @Valid Long id) {
        userService.removeUserById(id);
        return ResponseEntity.noContent().build();
    }

    // الأفضل REST shape
    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(@RequestParam(required = false) List<Long> ids) {
        return ResponseEntity.ok( userService.getUsers(ids));
    }

    @GetMapping("/with-posts")
    public ResponseEntity< List<usersWithPostDto>> getUsersWithPosts() {
        return ResponseEntity.ok( userService.getUsersWithPosts());
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity< usersWithPostDto> getUserWithPosts(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserWithPosts(id));
    }
}