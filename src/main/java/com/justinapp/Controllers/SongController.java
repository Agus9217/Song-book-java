package com.justinapp.Controllers;

import com.justinapp.Error.Exceptions.NotFound;
import com.justinapp.Error.ErrorResponse;
import com.justinapp.Models.DTO.SongDTO;
import com.justinapp.Models.Song;
import com.justinapp.Services.ISongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SongController {

    private final ISongService service;

    public SongController(ISongService service) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        try {
            List<SongDTO> result = service.findAll();
            return ResponseEntity.ok(result);
        } catch (NotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Song> save (@RequestBody SongDTO dto) {
        if (dto.getName().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        service.save(dto);
        return ResponseEntity.ok().build();
    }
}

