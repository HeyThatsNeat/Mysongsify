package com.hunterSongProject.mySongsify.service;

import com.hunterSongProject.mySongsify.entity.Song;
import com.hunterSongProject.mySongsify.exception.DefaultExceptionHandling;
import com.hunterSongProject.mySongsify.exception.ResourceNotFoundException;
import com.hunterSongProject.mySongsify.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
  private final SongRepository songRepository;

  public SongServiceImpl(SongRepository songRepository) {
    this.songRepository = songRepository;
  }

  @Override
  public List<Song> getAllSongs() {
    return songRepository.findAll();
  }

  @Override
  public Song getSongById(Long id) {
    return songRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Song with song id " + id + " was not found"));
  }

  @Override
  public Song addSong(Song song) {
    return songRepository.save(song);
  }

  @Override
  public void deleteSongById(Long id) {
    songRepository.deleteById(id);
  }

  @Override
  public Song updateSongById(Long id, Song song) {
    Song existingSong = getSongById(id);
    existingSong.setName(song.getName());
    existingSong.setAlbum(song.getAlbum());
    existingSong.setGenre(song.getGenre());
    existingSong.setArtist(song.getArtist());
    existingSong.setSongLength(song.getSongLength());
    songRepository.save(existingSong);
    return existingSong;
  }
}
