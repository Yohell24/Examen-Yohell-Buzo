/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.dto.CobroPendienteDTO;

public interface ICobroPendienteService {
    
    public Optional<CobroPendienteDTO> findById(Long id);
    
    public Optional<List<CobroPendienteDTO>> findByCliente(Long id);
    
    public CobroPendienteDTO create (CobroPendienteDTO cobro);
    
    public void deleteAll();
}
