package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ComunaRepository;
import com.example.demo.model.Comuna;
import java.util.List;

@Service
public class ComunaService {
    @Autowired
    private ComunaRepository comunaRepository;

    public List<Comuna> getAllComunas(){
        return comunaRepository.findAll();
    }

    public Comuna getComunaById(Integer id) {
        return comunaRepository.findById(id).orElse(null);
    }

    public Comuna saveComuna(Comuna comuna) {
        return comunaRepository.save(comuna);
    }

    public void deleteComuna(Integer id) {
        comunaRepository.deleteById(id);
    }
}
