/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.una.examen.dto.ClienteDTO;
import org.una.examen.repositories.IClienteRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;
import org.una.examen.entities.Cliente;

@Service
public class ClienteServiceImplementation implements IClienteService{

    @Autowired
    IClienteRepository clienteRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return ServiceConvertionHelper.OptionalOneToOptionalDto(clienteRepository.findById(id), ClienteDTO.class);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<ClienteDTO>> findAll() {
        return ServiceConvertionHelper.findList(clienteRepository.findAll(), ClienteDTO.class);
    }

    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO cliente) {
        Cliente entidad = MapperUtils.EntityFromDto(cliente, Cliente.class);
        entidad = clienteRepository.save(entidad);
        return MapperUtils.DtoFromEntity(entidad, ClienteDTO.class);
    }
}
