/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.controller;

import com.practica.pruebarest.dto.Mensaje;
import com.practica.pruebarest.entity.TipoDocumento;
import com.practica.pruebarest.service.TipoDocumentoService;
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
@RequestMapping("/documentos")
@CrossOrigin(origins = "*")
public class TipoDocumentoController {
    
    @Autowired
    TipoDocumentoService documentoService;

    @GetMapping("/list")
    public ResponseEntity<TipoDocumento> getAllDocuments(){
        List<TipoDocumento> lista = documentoService.list();
        return new ResponseEntity(lista,HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id_tipo_documento}")
    public ResponseEntity<TipoDocumento> getCustomer(@PathVariable("id_tipo_documento") int id) {
        if(!documentoService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"),HttpStatus.NOT_FOUND);
        TipoDocumento tdocument=documentoService.findById(id).get();
        return new ResponseEntity(tdocument,HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody TipoDocumento tipoDocumento){
        tipoDocumento.setIdTipoDocumento(null);
        documentoService.save(tipoDocumento);
        return new ResponseEntity(new Mensaje("Nuevo documento creado."),HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id_tipo_documento}")
    public ResponseEntity<?> update(@PathVariable("id_tipo_documento")int id, @RequestBody TipoDocumento tipoDocumento){
        TipoDocumento documento=documentoService.findById(id).get();
        documento.setDescripcion(tipoDocumento.getDescripcion());
        documento.setCodigo(tipoDocumento.getCodigo());
        documento.setNombre(tipoDocumento.getNombre());
        documento.setEstado(tipoDocumento.getEstado());
        documentoService.save(documento);
        return new ResponseEntity(new Mensaje("Documento Actualizado!"),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id_tipo_documento}")
    public ResponseEntity<?> delete(@PathVariable("id_tipo_documento")int id){
        if(!documentoService.existsById(id))
            return new ResponseEntity(new Mensaje("No existe"),HttpStatus.NOT_FOUND);
        documentoService.delete(id);
        return new ResponseEntity(new Mensaje("Documento eliminado"),HttpStatus.OK);
    }
}
