/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.controller;

import com.practica.pruebarest.dto.Mensaje;
import com.practica.pruebarest.entity.TipoContribuyente;
import com.practica.pruebarest.service.TipoContribuyenteService;
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
@RequestMapping("/contribuyentes")
@CrossOrigin(origins = "*")
public class TipoContribuyenteController {
    
    @Autowired
    TipoContribuyenteService contribuyenteService;
    
    @GetMapping("/list")
    public ResponseEntity<List<TipoContribuyente>> getAllContributors(){
        List<TipoContribuyente> lista = contribuyenteService.list();
        return new ResponseEntity(lista,HttpStatus.OK);
    }
    
     @GetMapping("/detail/{id}")
    public ResponseEntity<TipoContribuyente> getContributors(@PathVariable int id) {
        if(!contribuyenteService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"),HttpStatus.NOT_FOUND);
        TipoContribuyente tcontribuyente=contribuyenteService.findById(id).get();
        return new ResponseEntity(tcontribuyente,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoContribuyente tipoContribuyente){
        contribuyenteService.save(tipoContribuyente);
        return new ResponseEntity(new Mensaje("Nuevo contribuyente creado."),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody TipoContribuyente tipoContribuyente){
        TipoContribuyente contribuyente=contribuyenteService.findById(id).get();
        contribuyente.setNombre(tipoContribuyente.getNombre());
        contribuyente.setEstado(tipoContribuyente.getEstado());
        contribuyenteService.save(contribuyente);
        return new ResponseEntity(new Mensaje("Contribuyente Actualizado!"),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!contribuyenteService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        contribuyenteService.delete(id);
        return new ResponseEntity(new Mensaje("Contribuyente eliminado"),HttpStatus.OK);
    }
}
