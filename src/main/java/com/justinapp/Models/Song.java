package com.justinapp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "canciones")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "letra", length = 6000)
    private String description;

    @Column(name = "nota")
    private String note;

    @OneToOne(targetEntity = Author.class, cascade = CascadeType.ALL, orphanRemoval = true)
    private Author author;

    public Song() {
    }

    public Song(Long id, String name, String description, String note, Author author) {
        this.id = id;
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
