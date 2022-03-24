package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private long id;
    private String name;
    private String singer;
    private String genre;
    private MultipartFile fileName;

    public SongForm() {
    }

    public SongForm(String name, String singer, String genre, MultipartFile fileName) {
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.fileName = fileName;
    }

    public SongForm(long id, String name, String singer, String genre, MultipartFile fileName) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.genre = genre;
        this.fileName = fileName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public MultipartFile getFileName() {
        return fileName;
    }

    public void setFileName(MultipartFile fileName) {
        this.fileName = fileName;
    }
}
