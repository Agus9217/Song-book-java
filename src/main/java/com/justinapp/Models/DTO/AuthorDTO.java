package com.justinapp.Models.DTO;

import com.justinapp.Models.Song;

public class AuthorDTO {

    private String name;
    private Song song;

    public AuthorDTO() {
    }

    public AuthorDTO(String name, Song song) {
        this.name = name;
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
