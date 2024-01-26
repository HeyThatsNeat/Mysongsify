package com.hunterSongProject.mySongsify.repository;

import com.hunterSongProject.mySongsify.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
