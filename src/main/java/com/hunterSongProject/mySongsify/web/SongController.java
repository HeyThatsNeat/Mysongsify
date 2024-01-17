package com.hunterSongProject.mySongsify.web;

import com.hunterSongProject.mySongsify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/song")
public class SongController {
  @Autowired
  private SongService songService;

}
