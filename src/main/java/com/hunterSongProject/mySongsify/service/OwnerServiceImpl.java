package com.hunterSongProject.mySongsify.service;

import com.hunterSongProject.mySongsify.entity.Owner;
import com.hunterSongProject.mySongsify.exception.ResourceNotFoundException;
import com.hunterSongProject.mySongsify.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
  private final OwnerRepository ownerRepository;

  public OwnerServiceImpl(OwnerRepository ownerRepository) {
    this.ownerRepository = ownerRepository;
  }

  @Override
  public List<Owner> getAllUsers() {
    return ownerRepository.findAll();
  }

  @Override
  public Owner getOwnerById(Long id) {
    return ownerRepository.findById(id).orElseThrow( () -> new ResourceNotFoundException("Owner with id " + id + " does not exist"));
  }

  @Override
  public Owner addOwner(Owner owner) {
    return ownerRepository.save(owner);
  }

  @Override
  public void deleteOwnerById(Long id) {
    ownerRepository.deleteById(id);
  }

  @Override
  public Owner updateOwnerById(Long id, Owner owner) {
    Owner existingOwner = getOwnerById(id);
    existingOwner.setFirstName(owner.getFirstName());
    existingOwner.setLastName(owner.getLastName());
    ownerRepository.save(existingOwner);
    return existingOwner;
  }
}
