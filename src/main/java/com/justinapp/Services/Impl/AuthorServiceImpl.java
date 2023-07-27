package com.justinapp.Services.Impl;

import com.justinapp.Models.Author;
import com.justinapp.Models.DTO.AuthorDTO;
import com.justinapp.Models.Song;
import com.justinapp.Repositories.IAuthorRepository;
import com.justinapp.Services.IAuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements IAuthorService {

    private final IAuthorRepository authorRepository;

    public AuthorServiceImpl(IAuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDTO> findAll() {
        List<Author> authorList = authorRepository.findAll();
        return authorList.stream().map(song -> {
            AuthorDTO dto = new AuthorDTO();
            dto.setName(song.getName());
            dto.setSong((Song) song.getSong());
            return dto;
        }).toList();
    }

    @Override
    public AuthorDTO findById(Long id) {
        Optional<Author> authorOptional = authorRepository.findById(id);
        if (authorOptional.isPresent()) {
            AuthorDTO dto = new AuthorDTO();
            Author author = authorOptional.get();
            dto.setName(author.getName());
            dto.setSong((Song) author.getSong());
            return dto;
        }
        throw new IllegalArgumentException("Ingresa un ID válido");
    }

    @Override
    public Author save(AuthorDTO authorDTO) {
        if (authorDTO.getName().isEmpty()) {
            throw new IllegalArgumentException("Ingresa nombre del autor ");
        }
        Author author = new Author();
        author.setName(authorDTO.getName());
        return authorRepository.save(author);
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Ingresa un ID válido");
        }
        authorRepository.deleteById(id);
    }
}
