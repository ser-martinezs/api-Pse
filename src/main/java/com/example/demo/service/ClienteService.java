package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import com.example.demo.model.Cliente;
import java.util.List;

@Service
@Transactional
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes(){
        return clienteRepository.findAll();
    }

    public Cliente getClienteById(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente saveCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteCliente(Integer id) {
        clienteRepository.deleteById(id);
    }
}
