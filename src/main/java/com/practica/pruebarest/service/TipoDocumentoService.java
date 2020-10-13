/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.service;

import com.practica.pruebarest.entity.TipoDocumento;
import com.practica.pruebarest.repository.TipoDocumentoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDocumentoService {
    @Autowired
    TipoDocumentoRepository documentoRepository;
    
    public List<TipoDocumento> list(){
        return documentoRepository.findAll();
    }
    
    public Optional<TipoDocumento> findById(int id){
        return documentoRepository.findById(id);
    }
    
    public boolean existsById(int id){
        return documentoRepository.existsById(id);
    }
    
    public void save(TipoDocumento tipoDocumento){
        documentoRepository.save(tipoDocumento);
    } 
    
    public void delete(int id){
        documentoRepository.deleteById(id);
    }
    
}

