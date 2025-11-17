package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.Pedido;
import com.example.demo.service.PedidoService;

@RestController
@RequestMapping("api/v1/pedidos")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<Pedido>> getAllPedidos() {
        List<Pedido> pedidos = pedidoService.getAllPedidos();
        if (pedidos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Integer id) {
        Pedido pedido = pedidoService.getPedidoById(id);
        if (pedido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> createPedido(@RequestBody Pedido pedido) {
        Pedido createPedido = pedidoService.savePedido(pedido);
        return ResponseEntity.ok(createPedido);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pedido> updatePedido(@PathVariable Integer id, @RequestBody Pedido pedido) {
        pedido.setId(id);
        Pedido updatedPedido = pedidoService.savePedido(pedido);
        if (updatedPedido == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedPedido);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable Integer id) {
        pedidoService.deletePedido(id);
        return ResponseEntity.noContent().build();
    }
}
