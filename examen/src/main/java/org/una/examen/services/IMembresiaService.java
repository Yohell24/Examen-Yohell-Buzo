/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.dto.MembresiaDTO;

public interface IMembresiaService {
    
    public Optional<MembresiaDTO> findById(Long id);
    
    public Optional<List<MembresiaDTO>> findAll();
    
    public MembresiaDTO create(MembresiaDTO membresia);
}
