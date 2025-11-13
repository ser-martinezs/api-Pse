package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.DetallePedido;
import com.example.demo.service.DetallePedidoService;

@RestController
@RequestMapping("api/detallepedidos")
public class DetallePedidoController {
    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> getAllDetallePedidos() {
        List<DetallePedido> detallePedidos = detallePedidoService.getAllDetallePedidos();
        if (detallePedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detallePedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable Integer id) {
        DetallePedido detallePedido = detallePedidoService.getDetallePedidoById(id);
        if (detallePedido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(detallePedido);
    }

    @PostMapping
    public ResponseEntity<DetallePedido> createDetallePedido(@RequestBody DetallePedido detallePedido) {
        DetallePedido createDetallePedido = detallePedidoService.saveDetallePedido(detallePedido);
        return ResponseEntity.ok(createDetallePedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> updateDetallePedido(@PathVariable Integer id, @RequestBody DetallePedido detallePedido) {
        detallePedido.setId(id);
        DetallePedido updatedDetallePedido = detallePedidoService.saveDetallePedido(detallePedido);
        if (updatedDetallePedido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedDetallePedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDetallePedido(@PathVariable Integer id) {
        detallePedidoService.deleteDetallePedido(id);
        return ResponseEntity.noContent().build();
    }
}
