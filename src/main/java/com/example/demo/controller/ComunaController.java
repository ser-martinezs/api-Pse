package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.Comuna;
import com.example.demo.service.ComunaService;

@RestController
@RequestMapping("api/v1/comunas")
public class ComunaController {
    @Autowired
    private ComunaService comunaService;

    @GetMapping
    public ResponseEntity<List<Comuna>> getAllComunas() {
        List<Comuna> comunas = comunaService.getAllComunas();
        if (comunas.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comunas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comuna> getComunaById(@PathVariable Integer id) {
        Comuna comuna = comunaService.getComunaById(id);
        if (comuna == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(comuna);
    }

    @PostMapping
    public ResponseEntity<Comuna> createComuna(@RequestBody Comuna comuna) {
        Comuna createComuna = comunaService.saveComuna(comuna);
        return ResponseEntity.ok(createComuna);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comuna> updateComuna(@PathVariable Integer id, @RequestBody Comuna comuna) {
        comuna.setId(id);
        Comuna updatedComuna = comunaService.saveComuna(comuna);
        if (updatedComuna == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedComuna);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComuna(@PathVariable Integer id) {
        comunaService.deleteComuna(id);
        return ResponseEntity.noContent().build();
    }
}
