package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.demo.model.Region;
import com.example.demo.service.RegionService;

@RestController
@RequestMapping("api/v1/regiones")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegiones() {
        List<Region> regiones = regionService.getAllRegiones();
        if (regiones.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(regiones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable Integer id) {
        Region region = regionService.getRegionById(id);
        if (region == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(region);
    }

    @PostMapping
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region createRegion = regionService.saveRegion(region);
        return ResponseEntity.ok(createRegion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Region> updateRegion(@PathVariable Integer id, @RequestBody Region region) {
        region.setId(id);
        Region updatedRegion = regionService.saveRegion(region);
        if (updatedRegion == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(updatedRegion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRegion(@PathVariable Integer id) {
        regionService.deleteRegion(id);
        return ResponseEntity.noContent().build();
    }
}
