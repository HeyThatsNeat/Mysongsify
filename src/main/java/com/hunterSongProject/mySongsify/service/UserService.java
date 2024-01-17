package com.hunterSongProject.mySongsify.service;

import com.hunterSongProject.mySongsify.entity.User;

import java.util.List;

public interface UserService {
  List<User> getAllUsers();

  User getUserById(Long id);

  User addUser(User use);

  void deleteUserById(Long id);

  User updateUserById(Long id, User user);

}
