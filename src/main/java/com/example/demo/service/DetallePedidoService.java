package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DetallePedidoRepository;
import com.example.demo.model.DetallePedido;
import java.util.List;

@Service
public class DetallePedidoService {
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<DetallePedido> getAllDetallePedidos(){
        return detallePedidoRepository.findAll();
    }

    public DetallePedido getDetallePedidoById(Integer id) {
        return detallePedidoRepository.findById(id).orElse(null);
    }

    public DetallePedido saveDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepository.save(detallePedido);
    }

    public void deleteDetallePedido(Integer id) {
        detallePedidoRepository.deleteById(id);
    }
}
