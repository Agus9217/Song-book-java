package com.justinapp.Controllers;

import com.justinapp.Error.Exceptions.BadRequest;
import com.justinapp.Error.Exceptions.NoContent;
import com.justinapp.Error.Exceptions.NotFound;
import com.justinapp.Error.ErrorResponse;
import com.justinapp.Models.DTO.SongDTO;
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

    @GetMapping("/findById/{id}")
    public ResponseEntity<?>findById(@PathVariable Long id) {
        try {
            SongDTO dto = service.findById(id);
            return ResponseEntity.ok(dto);
        } catch (NotFound e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.NOT_FOUND.value(),
                    e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> save (@RequestBody SongDTO dto) {
        try {
            service.save(dto);
            return ResponseEntity.ok().build();
        } catch (BadRequest e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody SongDTO dto) {
        try {
            service.update(id, dto);
            return ResponseEntity.ok(dto);
        } catch (BadRequest e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.BAD_REQUEST.value(),
                    e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteById (@PathVariable Long id) {
        try {
            service.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (NoContent e) {
            ErrorResponse errorResponse = new ErrorResponse(
                    HttpStatus.NO_CONTENT.value(),
                    e.getMessage()
            );
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(errorResponse);
        }
    }
}

