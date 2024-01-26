package com.hunterSongProject.mySongsify.web;

import com.hunterSongProject.mySongsify.entity.Owner;
import com.hunterSongProject.mySongsify.entity.User;
import com.hunterSongProject.mySongsify.service.OwnerService;
import com.hunterSongProject.mySongsify.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class OwnerController {
  @Autowired
  private OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @GetMapping("/owners")
  public ResponseEntity<List<Owner>> getAllOwners() {
    return new ResponseEntity<>(ownerService.getAllOwners(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Owner> getOwnerById(@PathVariable Long id) {
    return new ResponseEntity<>(ownerService.getOwnerById(id), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Owner> addOwner(@RequestBody Owner owner) {
    return new ResponseEntity<>(ownerService.addOwner(owner), HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Owner> deleteOwnerById(@PathVariable Long id) {
    ownerService.deleteOwnerById(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Owner> updateOwnerById(@PathVariable Long id, @RequestBody Owner owner) {
    return new ResponseEntity<>(ownerService.updateOwnerById(id, owner), HttpStatus.ACCEPTED);
  }

}
