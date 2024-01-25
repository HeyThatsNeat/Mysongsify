package com.hunterSongProject.mySongsify.entity;

import jakarta.persistence.*;

@Entity
public class Song {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private String album;
  private String genre;
  private String artist;
  private String songLength;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "owner")
  private User user;

  public Song() {
    //hibernate will use this
  }

  public Song(String name, String album, String genre, String artist, String songLength, User user) {
    this.name = name;
    this.album = album;
    this.genre = genre;
    this.artist = artist;
    this.songLength = songLength;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAlbum() {
    return album;
  }

  public void setAlbum(String album) {
    this.album = album;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }

  public String getSongLength() {
    return songLength;
  }

  public void setSongLength(String songLength) {
    this.songLength = songLength;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Song{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", album='" + album + '\'' +
            ", genre='" + genre + '\'' +
            ", artist='" + artist + '\'' +
            ", songLength='" + songLength + '\'' +
            '}';
  }
}
