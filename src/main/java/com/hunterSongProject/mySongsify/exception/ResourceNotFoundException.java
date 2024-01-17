package com.hunterSongProject.mySongsify.exception;

public class ResourceNotFoundException extends RuntimeException{
  public ResourceNotFoundException(String message){
    super(message);
  }
}
