package com.hunterSongProject.mySongsify.service;

import com.hunterSongProject.mySongsify.entity.User;
import com.hunterSongProject.mySongsify.exception.ResourceNotFoundException;
import com.hunterSongProject.mySongsify.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("User with id " + id + " does not exist"));
  }

  @Override
  public User addUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public void deleteUserById(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  public User updateUserById(Long id, User user) {
    User existingUser = getUserById(id);
    existingUser.setFirstName(user.getFirstName());
    existingUser.setLastName(user.getLastName());
    userRepository.save(existingUser);
    return existingUser;
  }
}
