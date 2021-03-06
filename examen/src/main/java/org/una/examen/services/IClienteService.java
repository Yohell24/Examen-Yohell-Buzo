/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.una.examen.dto.ClienteDTO;

public interface IClienteService {
    
    public Optional<ClienteDTO> findById(Long id);
    
    public Optional<List<ClienteDTO>> findAll();
    
    public ClienteDTO create(ClienteDTO cliente);
}
