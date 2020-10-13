/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.service;

import com.practica.pruebarest.entity.TipoContribuyente;
import com.practica.pruebarest.repository.TipoContribuyenteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoContribuyenteService {
    
    @Autowired
    TipoContribuyenteRepository contribuyenteRepository;
    
    
    public List<TipoContribuyente> list(){
        return contribuyenteRepository.findAll();
    }
    
    public Optional<TipoContribuyente> findById(int id){
        return contribuyenteRepository.findById(id);
    }
    
    public boolean existsById(int id){
        return contribuyenteRepository.existsById(id);
    }
    
    public void save(TipoContribuyente tipoContribuyente){
        contribuyenteRepository.save(tipoContribuyente);
    }
    
    public void delete(int id){
        contribuyenteRepository.deleteById(id);
    }
}
