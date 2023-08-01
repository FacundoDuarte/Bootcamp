package com.facundoduarte.mvc.mvc.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.facundoduarte.mvc.mvc.models.Song;
import com.facundoduarte.mvc.mvc.repositories.SongRepository;

@Service
public class SongServices {
    private final SongRepository songRepository;

    public SongServices(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> allSongs() {
        return songRepository.findAll();
    }

    public Song createSong(Song s) {
        return songRepository.save(s);
    }

    public List<Song> topTenSongs() {
        return songRepository.findTop10SongByOrderByRatingDesc();
    }

    public List<Song> songByArtist(String artist) {
        return songRepository.findByArtist(artist);
    }

    public Song findSong(Long id) {
        Optional<Song> optionalSong = songRepository.findById(id);
        if (optionalSong.isPresent()) {
            return optionalSong.get();
        } else {
            return null;
        }
    }

    public Song updateSong(Song s) {
        Optional<Song> optionalSong = songRepository.findById(s.getId());
        if (optionalSong.isPresent()) {
            Song updatedSong = songRepository.save(s);
            return updatedSong;
        } else {
            return null;
        }
    }

    public void deleteSong(Long id) {
        songRepository.deleteById(id);
    }

    public Song searchByArtist(String name) {
        Song songByArtist = songRepository.findByName(name);
        if (songByArtist == null) {
            throw new NoSuchElementException("No se encontró ninguna canción del artista: " + name);
        }
        return songByArtist;
    }
}
