package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.DetallePedidoRepository;
import com.example.demo.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import com.example.demo.model.Pedido;
import java.util.List;

@Service
@Transactional
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    public List<Pedido> getAllPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findById(id).orElse(null);
    }

    public Pedido savePedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public void deletePedido(Integer id) {
        detallePedidoRepository.deleteByPedidoId(id);
        pedidoRepository.deleteById(id);
    }
}
