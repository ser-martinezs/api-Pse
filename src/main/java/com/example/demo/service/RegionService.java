package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RegionRepository;
import com.example.demo.model.Region;
import java.util.List;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getAllRegiones(){
        return regionRepository.findAll();
    }

    public Region getRegionById(Integer id) {
        return regionRepository.findById(id).orElse(null);
    }

    public Region saveRegion(Region region) {
        return regionRepository.save(region);
    }

    public void deleteRegion(Integer id) {
        regionRepository.deleteById(id);
    }
}
