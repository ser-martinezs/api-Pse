package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EstadoPedidoRepository;
import jakarta.transaction.Transactional;
import com.example.demo.model.EstadoPedido;
import java.util.List;

@Service
@Transactional
public class EstadoPedidoService {
    @Autowired
    private EstadoPedidoRepository estadoPedidoRepository;

    public List<EstadoPedido> getAllEstadoPedidos(){
        return estadoPedidoRepository.findAll();
    }

    public EstadoPedido getEstadoPedidoById(Integer id) {
        return estadoPedidoRepository.findById(id).orElse(null);
    }

    public EstadoPedido saveEstadoPedido(EstadoPedido estadoPedido) {
        return estadoPedidoRepository.save(estadoPedido);
    }

    public void deleteEstadoPedido(Integer id) {
        estadoPedidoRepository.deleteById(id);
    }
}
