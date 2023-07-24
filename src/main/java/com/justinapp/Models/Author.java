package com.justinapp.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "autor")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @OneToOne(mappedBy = "author", fetch = FetchType.EAGER)
    private Song song;

    public Author() {
    }

    public Author(Long id, String name, Song song) {
        this.id = id;
        this.name = name;
        this.song = song;
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

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
