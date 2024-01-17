package com.hunterSongProject.mySongsify.web;

import com.hunterSongProject.mySongsify.entity.Song;
import com.hunterSongProject.mySongsify.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/song")
public class SongController {
  @Autowired
  private SongService songService;

  public SongController(SongService songService) {
    this.songService = songService;
  }

  @GetMapping("/songs")
  public ResponseEntity<List<Song>> getAllSongs() {
    return new ResponseEntity<>(songService.getAllSongs(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Song> getSongById(Long id) {
    return new ResponseEntity<>(songService.getSongById(id), HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<Song> addSong(@RequestBody Song song) {
    return new ResponseEntity<>(songService.addSong(song), HttpStatus.CREATED);
  }

  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Song> deleteSongById(@PathVariable Long id) {
    songService.deleteSongById(id);
    return new ResponseEntity<>(HttpStatus.ACCEPTED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Song> updateSongById(@PathVariable Long id, @RequestBody Song song) {
    return new ResponseEntity<>(songService.updateSongById(id, song), HttpStatus.ACCEPTED);
  }

}
