package com.example.restful.controllers;


import com.example.restful.entity.User;
import com.example.restful.model.dto.UserDto;
import com.example.restful.servive.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public ResponseEntity<?> getListUser() {
    List<UserDto> users = userService.getListUser();
    return ResponseEntity.ok(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable int id) {
    UserDto user = userService.getUserById(id);
    return ResponseEntity.ok(user);
  }

  @GetMapping("/search")
  public ResponseEntity<?> searchUser(@RequestParam(name = "keyword", required = false, defaultValue = "") String name) {
    List<UserDto> users = userService.searchUser(name);
    return ResponseEntity.ok(users);
  }

  @PostMapping("")
  public ResponseEntity<?> createUser(@RequestBody User user) {
    int id = user.getId();
    String name = user.getName();
    String email = user.getEmail();
    String phone = user.getPhone();
    String avatar = user.getAvatar();
    User newUser = userService.createUser(user);
    return ResponseEntity.ok(newUser);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDto updateUser) {
    updateUser.setId(updateUser.getId());
    updateUser.setName(updateUser.getName());
    updateUser.setEmail(updateUser.getEmail());
    updateUser.setPhone(updateUser.getPhone());
    updateUser.setAvatar(updateUser.getAvatar());
    UserDto result = userService.updateUser(id);
    return ResponseEntity.ok(result);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable int id) {
    UserDto user = userService.deleteUser(id);
    return ResponseEntity.ok(user);
  }
}
