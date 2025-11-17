package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.MetodoPagoRepository;
import jakarta.transaction.Transactional;
import com.example.demo.model.MetodoPago;
import java.util.List;

@Service
@Transactional
public class MetodoPagoService {
    @Autowired
    private MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> getAllMetodoPagos(){
        return metodoPagoRepository.findAll();
    }

    public MetodoPago getMetodoPagoById(Integer id) {
        return metodoPagoRepository.findById(id).orElse(null);
    }

    public MetodoPago saveMetodoPago(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public void deleteMetodoPago(Integer id) {
        metodoPagoRepository.deleteById(id);
    }
}
