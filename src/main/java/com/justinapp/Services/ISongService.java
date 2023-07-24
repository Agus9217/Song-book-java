package com.justinapp.Services;

import com.justinapp.Models.DTO.SongDTO;
import com.justinapp.Models.Song;

import java.util.List;

public interface ISongService {

    List<SongDTO>findAll();
    SongDTO findById(Long id);
    Song save(SongDTO songDTO);
    void deleteById(Long id);
}
