package com.example.construindo_API_REST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String mensagemBoasVindas() {
        return "Seja bem-vindo(a) ao Song";
    }

    @GetMapping(path = "/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping(path = "/findSong/{id}")
    public Song findSongById(@PathVariable Integer id) {
        return songRepository.getSongById(id);
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public Song addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        return songRepository.getSongById(song.getId());
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public Song updadeSong(@RequestBody Song song) {
        songRepository.updateSong(song);
        return songRepository.getSongById(song.getId());
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json", produces = "application/json")
    public void deleteSongById(@RequestBody Song song) {
        songRepository.removeSong(song);
    }
}