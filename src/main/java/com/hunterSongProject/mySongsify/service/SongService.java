package com.hunterSongProject.mySongsify.service;
import com.hunterSongProject.mySongsify.entity.Song;
import java.util.List;

public interface SongService {
  List<Song> getAllSongs();

  Song getSongById(Long id);

  Song addSong(Song song);

  void deleteSongById(Long id);

  Song updateSongById(Long id, Song song);


}
