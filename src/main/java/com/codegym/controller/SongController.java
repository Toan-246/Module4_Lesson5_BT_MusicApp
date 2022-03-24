package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class SongController {
    @Value("${file-upload}")
    private String uploadPath;
    @Autowired
    private SongService songService;

    @GetMapping("/songs/list")
    public ModelAndView showListSong() {
        ModelAndView modelAndView = new ModelAndView("song/list");
        List<Song> songs = songService.findAll();
        modelAndView.addObject("songs", songs);
        return modelAndView;
    }

    @GetMapping("/songs/create")
    ModelAndView showUploadForm() {
        ModelAndView modelAndView = new ModelAndView("/song/create");
        modelAndView.addObject("song", new SongForm());
        return modelAndView;
    }

    @PostMapping("/songs/upload")
    ModelAndView uploadSong(@ModelAttribute SongForm songForm) {
        String filename = songForm.getFileName().getOriginalFilename();
        long currentTime = System.currentTimeMillis();
        filename = currentTime + filename;
        try {
            FileCopyUtils.copy(songForm.getFileName().getBytes(), new File(uploadPath + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Song song = new Song(songForm.getId(), songForm.getName(), songForm.getSinger(), songForm.getGenre(), filename);
        return new ModelAndView("redirect:/songs/list");
    }
}
