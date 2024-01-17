package com.hunterSongProject.mySongsify.repository;

import com.hunterSongProject.mySongsify.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
