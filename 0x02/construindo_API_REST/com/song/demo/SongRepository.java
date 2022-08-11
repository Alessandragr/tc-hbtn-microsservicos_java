package com.example.construindo_API_REST;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {

    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return this.list;
    }

    public Song getSongById(Integer id) {
        for (Song song: list) {
            if (id.equals(song.getId()))
                return this.list.get(id);
            
        }
        return null;
    }

    public void addSong(Song s) {
        this.list.add(s);
    }

    public void updateSong(Song s) {
        for (Song song: list) {
            if (song.getId() == s.getId())
                this.list.set(this.list.indexOf(song), s);
        }
    }

    public void removeSong(Song s) {
        if (this.list.contains(s))
            this.list.remove(s);
    }


}
