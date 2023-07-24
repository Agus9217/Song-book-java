package com.justinapp.Services;

import com.justinapp.Models.Author;
import com.justinapp.Models.DTO.AuthorDTO;

import java.util.List;

public interface IAuthorService {
    List<AuthorDTO>findAll();
    AuthorDTO findById(Long id);
    Author save(AuthorDTO authorDTO);
    void deleteById(Long id);
}
