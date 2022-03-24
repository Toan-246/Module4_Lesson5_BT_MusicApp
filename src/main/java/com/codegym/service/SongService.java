package com.codegym.service;

import com.codegym.dao.ISongDao;
import com.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService{
    @Autowired
    private ISongDao songDao;
    @Override
    public List<Song> findAll() {
        return songDao.findAll();
    }

    @Override
    public Song findById(long id) {
        return songDao.findById(id);
    }

    @Override
    public Song save(Song song) {
        return songDao.save(song);
    }

    @Override
    public void removeById(long id) {
        songDao.removeById(id);
    }
}
