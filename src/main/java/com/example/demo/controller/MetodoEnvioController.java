package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.MetodoEnvio;
import com.example.demo.service.MetodoEnvioService;

@RestController
@RequestMapping("api/metodoenvios")
public class MetodoEnvioController {
    @Autowired
    private MetodoEnvioService metodoEnvioService;

    @GetMapping
    public ResponseEntity<List<MetodoEnvio>> getAllMetodoEnvios() {
        List<MetodoEnvio> metodoEnvios = metodoEnvioService.getAllMetodoEnvios();
        if (metodoEnvios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoEnvios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoEnvio> getMetodoEnvioById(@PathVariable Integer id) {
        MetodoEnvio metodoEnvio = metodoEnvioService.getMetodoEnvioById(id);
        if (metodoEnvio == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoEnvio);
    }

    @PostMapping
    public ResponseEntity<MetodoEnvio> createMetodoEnvio(@RequestBody MetodoEnvio metodoEnvio) {
        MetodoEnvio createMetodoEnvio = metodoEnvioService.saveMetodoEnvio(metodoEnvio);
        return ResponseEntity.ok(createMetodoEnvio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoEnvio> updateMetodoEnvio(@PathVariable Integer id, @RequestBody MetodoEnvio metodoEnvio) {
        metodoEnvio.setId(id);
        MetodoEnvio updatedMetodoEnvio = metodoEnvioService.saveMetodoEnvio(metodoEnvio);
        if (updatedMetodoEnvio == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedMetodoEnvio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoEnvio(@PathVariable Integer id) {
        metodoEnvioService.deleteMetodoEnvio(id);
        return ResponseEntity.noContent().build();
    }
}
