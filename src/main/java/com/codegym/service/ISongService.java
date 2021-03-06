package com.codegym.service;

import com.codegym.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();

    Song findById(long id);

    Song save(Song song);

    void removeById(long id);
}
