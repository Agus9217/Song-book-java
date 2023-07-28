package com.justinapp.Services;

import com.justinapp.Models.DTO.SongDTO;

import java.util.List;

public interface ISongService {

    List<SongDTO>findAll();
    SongDTO findById(Long id);
    void save(SongDTO songDTO);
    void update(Long id, SongDTO songDTO);
    void deleteById(Long id);
}
