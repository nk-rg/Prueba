/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.controller;

import com.practica.pruebarest.dto.Mensaje;
import com.practica.pruebarest.entity.Entidad;
import com.practica.pruebarest.service.EntidadService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entidades")
@CrossOrigin(origins = "*")
public class EntidadController {
    
    @Autowired
    EntidadService entidadService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Entidad>> getAllEntities(){
        List<Entidad> lista = entidadService.list();
        return new ResponseEntity(lista,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Entidad> getById(@PathVariable("id") int id){
        if(!entidadService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Entidad entidad = entidadService.findById(id).get();
        return new ResponseEntity(entidad, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Entidad entidad){
        entidadService.save(entidad);
        return new ResponseEntity(new Mensaje("Entidad creada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody Entidad formEntidad){
        
        Entidad entidad = entidadService.findById(id).get();
        entidad.setNombreComercial(formEntidad.getNombreComercial());
        entidad.setDireccion(formEntidad.getDireccion());
        entidad.setIdEntidad(formEntidad.getIdEntidad());
        entidad.setNroDocumento(formEntidad.getNroDocumento());
        entidad.setRazonSocial(formEntidad.getRazonSocial());
        entidad.setTelefono(formEntidad.getTelefono());
        entidad.setEstado(formEntidad.getEstado());
        entidad.setTipoContribuyente(formEntidad.getTipoContribuyente());
        entidad.setTipoDocumento(formEntidad.getTipoDocumento());
        entidadService.save(entidad);
        return new ResponseEntity(new Mensaje("Entidad actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!entidadService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        entidadService.delete(id);
        return new ResponseEntity(new Mensaje("Entidad eliminada"), HttpStatus.OK);
    }
}
