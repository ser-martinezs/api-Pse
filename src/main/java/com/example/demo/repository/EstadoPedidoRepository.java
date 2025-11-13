package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.EstadoPedido;

@Repository
public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido,Integer>{
}
