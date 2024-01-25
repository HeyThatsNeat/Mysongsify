package com.hunterSongProject.mySongsify.web;

import com.hunterSongProject.mySongsify.entity.User;
import com.hunterSongProject.mySongsify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
  @Autowired
  private UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
    return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<User> addUser(@RequestBody User user) {
    return new ResponseEntity<>(userService.addUser(user), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
    userService.deleteUserById(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
    return new ResponseEntity<>(userService.updateUserById(id, user), HttpStatus.ACCEPTED);
  }

}
