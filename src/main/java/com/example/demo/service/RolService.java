package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.RolRepository;
import jakarta.transaction.Transactional;
import com.example.demo.model.Rol;
import java.util.List;

@Service
@Transactional
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getAllRoles(){
        return rolRepository.findAll();
    }

    public Rol getRolById(Integer id) {
        return rolRepository.findById(id).orElse(null);
    }

    public Rol saveRol(Rol rol) {
        return rolRepository.save(rol);
    }

    public void deleteRol(Integer id) {
        rolRepository.deleteById(id);
    }
}
