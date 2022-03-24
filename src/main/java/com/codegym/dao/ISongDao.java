package com.codegym.dao;

import com.codegym.model.Song;

import java.util.List;

public interface ISongDao {
    List<Song> findAll();

    Song findById(long id);

    Song save(Song song);

    void removeById(long id);
}
