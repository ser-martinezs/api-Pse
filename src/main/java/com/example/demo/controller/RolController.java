package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.Rol;
import com.example.demo.service.RolService;

@RestController
@RequestMapping("api/roles")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping
    public ResponseEntity<List<Rol>> getAllRoles() {
        List<Rol> roles = rolService.getAllRoles();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> getRolById(@PathVariable Integer id) {
        Rol rol = rolService.getRolById(id);
        if (rol == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(rol);
    }

    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol rol) {
        Rol createRol = rolService.saveRol(rol);
        return ResponseEntity.ok(createRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rol> updateRol(@PathVariable Integer id, @RequestBody Rol rol) {
        rol.setId(id);
        Rol updatedRol = rolService.saveRol(rol);
        if (updatedRol == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRol(@PathVariable Integer id) {
        rolService.deleteRol(id);
        return ResponseEntity.noContent().build();
    }
}
