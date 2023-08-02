package com.facundoduarte.mvc.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.facundoduarte.mvc.mvc.models.Song;
import com.facundoduarte.mvc.mvc.services.SongServices;

import jakarta.validation.Valid;

@Controller
public class SongController {
    private final SongServices songServices;

    public SongController(SongServices songServices) {
        this.songServices = songServices;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, @ModelAttribute("song") Song song) {
        List<Song> songs = songServices.allSongs();
        model.addAttribute("songs", songs);
        return "dashboard";
    }

    @GetMapping("/songs/{id}")
    public String showSong(Model model, @ModelAttribute("song") Song song) {
        Song findSong = songServices.findSong(song.getId());
        model.addAttribute("song", findSong);
        return "song";
    }

    @RequestMapping("/songs/new")
    public String newSong(@ModelAttribute("song") Song song) {
        return "new";
    }

    @RequestMapping(value = "/songs/new", method = RequestMethod.POST)
    public String createSong(@Valid @ModelAttribute("song") Song song, BindingResult result) {
        if (result.hasErrors()) {
            return "new";
        } else {
            songServices.createSong(song);
            return "redirect:/dashboard";
        }
    }

    @PostMapping("/search/")
    public String findSongByArtist(@RequestParam(value = "artist") String artista, Model model) {
        List<Song> songByArtist = songServices.songByArtist(artista);
        model.addAttribute("songs", songByArtist);
        return "songByArtist";
    }

    @GetMapping("/search/topTen")
    public String topTen(Model model) {
        List<Song> topTenSongs = songServices.topTenSongs();
        model.addAttribute("songs", topTenSongs);
        return "topTen";
    }

    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        songServices.deleteSong(id);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/search/{id}", method = RequestMethod.DELETE)
    public String destroySearch(@PathVariable("id") Long id) {
        songServices.deleteSong(id);
        return "redirect:/dashboard";
    }

    @RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE)
    public String destroySong(@PathVariable("id") Long id) {
        songServices.deleteSong(id);
        return "redirect:/dashboard";
    }
}
