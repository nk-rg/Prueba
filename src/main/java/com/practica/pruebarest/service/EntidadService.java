/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.service;

import com.practica.pruebarest.entity.Entidad;
import com.practica.pruebarest.repository.EntidadRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntidadService {
    
    @Autowired
    EntidadRepository entidadRepository;
    
    public List<Entidad> list(){
        return entidadRepository.findAll();
    }
    
    public Optional<Entidad> findById(int id){
        return entidadRepository.findById(id);
    }
    
    public boolean existsById(int id){
        return entidadRepository.existsById(id);
    }
    
    public void save(Entidad entidad){
        entidadRepository.save(entidad);
    }
    public void delete(int id){
        entidadRepository.deleteById(id);
    }
}
