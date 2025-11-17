package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.Categoria;
import com.example.demo.service.CategoriaService;

@RestController
@RequestMapping("api/v1/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        List<Categoria> categorias = categoriaService.getAllCategorias();
        if (categorias.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoriaById(@PathVariable Integer id) {
        Categoria categoria = categoriaService.getCategoriaById(id);
        if (categoria == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoria);
    }

    @PostMapping
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {
        Categoria createCategoria = categoriaService.saveCategoria(categoria);
        return ResponseEntity.ok(createCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Integer id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria updatedCategoria = categoriaService.saveCategoria(categoria);
        if (updatedCategoria == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedCategoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Integer id) {
        categoriaService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
