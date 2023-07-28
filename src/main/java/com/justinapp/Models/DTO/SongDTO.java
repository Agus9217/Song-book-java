package com.justinapp.Models.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.justinapp.Models.Author;

public class SongDTO {

    @JsonIgnore
    private Long id;
    private String name;
    private String description;
    private String note;

    @JsonIgnore
    private Author author;

    public SongDTO() {
    }

    public SongDTO(Long id, String name, String description, String note, Author author) {
        this.name = name;
        this.description = description;
        this.note = note;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
