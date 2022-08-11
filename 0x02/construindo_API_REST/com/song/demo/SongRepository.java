package com.song.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SongRepository {
    private List<Song> list = new ArrayList<Song>();

    public List<Song> getAllSongs() {
        return list;
    }

    public Song getSongById(Integer id) {
        if (id >= list.size()) {
            return null;
        }

        return list.get(id);
    }

    public void addSong(Song s) {
        list.add(s);
    }

    public void updateSong(Song s) {
        if (s.getId() < list.size()) {
            list.set(s.getId(), s);
        }
    }

    public void removeSong(Song s) {
        list.remove(s.getId());
    }
}
