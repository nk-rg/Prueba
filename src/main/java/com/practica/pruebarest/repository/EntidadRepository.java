/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practica.pruebarest.repository;

import com.practica.pruebarest.entity.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Gg_Di
 */
public interface EntidadRepository extends JpaRepository<Entidad, Integer>{
    
}
