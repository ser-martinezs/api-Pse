package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MetodoEnvioRepository;
import com.example.demo.model.MetodoEnvio;
import java.util.List;

@Service
public class MetodoEnvioService {
    @Autowired
    private MetodoEnvioRepository metodoEnvioRepository;

    public List<MetodoEnvio> getAllMetodoEnvios(){
        return metodoEnvioRepository.findAll();
    }

    public MetodoEnvio getMetodoEnvioById(Integer id) {
        return metodoEnvioRepository.findById(id).orElse(null);
    }

    public MetodoEnvio saveMetodoEnvio(MetodoEnvio metodoEnvio) {
        return metodoEnvioRepository.save(metodoEnvio);
    }

    public void deleteMetodoEnvio(Integer id) {
        metodoEnvioRepository.deleteById(id);
    }
}
