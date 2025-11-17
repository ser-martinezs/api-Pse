package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.EstadoPedido;
import com.example.demo.service.EstadoPedidoService;

@RestController
@RequestMapping("api/v1/estadopedidos")
public class EstadoPedidoController {
    @Autowired
    private EstadoPedidoService estadoPedidoService;

    @GetMapping
    public ResponseEntity<List<EstadoPedido>> getAllEstadoPedidos() {
        List<EstadoPedido> estadoPedidos = estadoPedidoService.getAllEstadoPedidos();
        if (estadoPedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadoPedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoPedido> getEstadoPedidoById(@PathVariable Integer id) {
        EstadoPedido estadoPedido = estadoPedidoService.getEstadoPedidoById(id);
        if (estadoPedido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(estadoPedido);
    }

    @PostMapping
    public ResponseEntity<EstadoPedido> createEstadoPedido(@RequestBody EstadoPedido estadoPedido) {
        EstadoPedido createEstadoPedido = estadoPedidoService.saveEstadoPedido(estadoPedido);
        return ResponseEntity.ok(createEstadoPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoPedido> updateEstadoPedido(@PathVariable Integer id, @RequestBody EstadoPedido estadoPedido) {
        estadoPedido.setId(id);
        EstadoPedido updatedEstadoPedido = estadoPedidoService.saveEstadoPedido(estadoPedido);
        if (updatedEstadoPedido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedEstadoPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstadoPedido(@PathVariable Integer id) {
        estadoPedidoService.deleteEstadoPedido(id);
        return ResponseEntity.noContent().build();
    }
}
