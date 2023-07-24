package com.justinapp.Controllers;

import com.justinapp.Exception.MyException;
import com.justinapp.Models.DTO.SongDTO;
import com.justinapp.Models.Song;
import com.justinapp.Response.ResponseMessages;
import com.justinapp.Services.ISongService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SongController {

    private final ISongService service;

    public SongController(ISongService service, ResponseMessages responseMessages) {
        this.service = service;
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        ResponseMessages responseMessages = new ResponseMessages();
        try {
            responseMessages.setStatus("error");
            responseMessages.setMessage("no content");
            List<SongDTO> result = service.findAll();
            return ResponseEntity.ok(result);
        } catch (MyException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
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

