package com.hunterSongProject.mySongsify;

import com.hunterSongProject.mySongsify.entity.Song;
import com.hunterSongProject.mySongsify.entity.User;
import com.hunterSongProject.mySongsify.repository.SongRepository;
import com.hunterSongProject.mySongsify.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MySongsifyApplication implements CommandLineRunner {
	@Autowired
	private SongRepository songRepository;
	@Autowired
	private OwnerRepository userRepository;

	private static final Logger logger = LoggerFactory.getLogger(MySongsifyApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(MySongsifyApplication.class, args);
		logger.info("Application started");
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("Hunter", "Eckhoff");
		User user2 = new User("HUNTY", "BUNTY");
		userRepository.save(user1);
		userRepository.save(user2);
		List<Song> songs = Arrays.asList(
						new Song("No Tears Left to Cry", "Sweetener", "Pop", "Ariana Grande", "3:50", user1),
						new Song("FTCU", "Pink Friday 2", "Rap", "Nikki Minaj", "3:23", user2)
		);
		songRepository.saveAll(songs);
		songRepository.findAll();
	}
}
