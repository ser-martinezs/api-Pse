package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.MetodoPago;
import com.example.demo.service.MetodoPagoService;

@RestController
@RequestMapping("api/v1/metodopagos")
public class MetodoPagoController {
    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping
    public ResponseEntity<List<MetodoPago>> getAllMetodoPagos() {
        List<MetodoPago> metodoPagos = metodoPagoService.getAllMetodoPagos();
        if (metodoPagos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoPagos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetodoPago> getMetodoPagoById(@PathVariable Integer id) {
        MetodoPago metodoPago = metodoPagoService.getMetodoPagoById(id);
        if (metodoPago == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(metodoPago);
    }

    @PostMapping
    public ResponseEntity<MetodoPago> createMetodoPago(@RequestBody MetodoPago metodoPago) {
        MetodoPago createMetodoPago = metodoPagoService.saveMetodoPago(metodoPago);
        return ResponseEntity.ok(createMetodoPago);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetodoPago> updateMetodoPago(@PathVariable Integer id, @RequestBody MetodoPago metodoPago) {
        metodoPago.setId(id);
        MetodoPago updatedMetodoPago = metodoPagoService.saveMetodoPago(metodoPago);
        if (updatedMetodoPago == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedMetodoPago);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMetodoPago(@PathVariable Integer id) {
        metodoPagoService.deleteMetodoPago(id);
        return ResponseEntity.noContent().build();
    }
}
