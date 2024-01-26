package com.hunterSongProject.mySongsify.service;

import com.hunterSongProject.mySongsify.entity.Owner;

import java.util.List;

public interface OwnerService {
  List<Owner> getAllOwners();

  Owner getOwnerById(Long id);

  Owner addOwner(Owner use);

  void deleteOwnerById(Long id);

  Owner updateOwnerById(Long id, Owner owner);

}
