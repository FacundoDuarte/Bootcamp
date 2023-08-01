package com.facundoduarte.mvc.mvc.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.facundoduarte.mvc.mvc.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {
    Song findByName(String name);

    List<Song> findAll();

    List<Song> findTop10SongByOrderByRatingDesc();

    List<Song> findByArtist(String artist);
}
