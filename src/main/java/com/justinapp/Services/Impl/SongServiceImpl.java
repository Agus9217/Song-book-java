package com.justinapp.Services.Impl;

import com.justinapp.Error.Exceptions.BadRequest;
import com.justinapp.Error.Exceptions.NoContent;
import com.justinapp.Error.Exceptions.NotFound;
import com.justinapp.Models.DTO.SongDTO;
import com.justinapp.Models.Song;
import com.justinapp.Repositories.ISongRepository;
import com.justinapp.Services.ISongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements ISongService {

    private final ISongRepository songRepository;

    public SongServiceImpl(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<SongDTO> findAll() {
        List<Song> songList = songRepository.findAll();
        if (songList.isEmpty()) {
            throw new NotFound("No hay ninguna cancion");
        }
        return songList.stream()
                .map(song -> {
                    SongDTO dto = new SongDTO();
                    dto.setName(song.getName());
                    dto.setAuthor(song.getAuthor());
                    dto.setDescription(song.getDescription());
                    dto.setNote(song.getNote());
                    return dto;
                }).toList();
    }

    @Override
    public SongDTO findById(Long id) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            SongDTO dto = new SongDTO();
            dto.setName(song.getName());
            dto.setAuthor(song.getAuthor());
            dto.setDescription(song.getDescription());
            dto.setNote(song.getNote());
            return dto;
        }
        throw new NotFound("No se encontro ninguna canción");
    }

    @Override
    public void save(SongDTO songDTO) {
        if (songDTO.getName().isEmpty()) {
            throw new BadRequest("Ingresa una canción válida");
        }
        Song song = new Song();
        song.setName(songDTO.getName());
        song.setDescription(songDTO.getDescription());
        song.setNote(songDTO.getNote());
        songRepository.save(song);
    }

    @Override
    public void update(Long id, SongDTO songDTO) {
        Optional<Song> songOptional = songRepository.findById(id);
        if (songOptional.isPresent()) {
            Song song = songOptional.get();
            song.setName(songDTO.getName());
            song.setDescription(songDTO.getDescription());
            song.setNote(songDTO.getNote());
            songRepository.save(song);
        }
    }

    @Override
    public void deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new NoContent("Ingresa un ID válido");
        }
        songRepository.deleteById(id);
    }
}
