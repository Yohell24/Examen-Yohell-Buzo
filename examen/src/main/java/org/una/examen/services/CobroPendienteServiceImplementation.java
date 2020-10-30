/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.examen.dto.CobroPendienteDTO;
import org.una.examen.entities.CobroPendiente;
import org.una.examen.repositories.ICobroPendienteRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;

@Service
public class CobroPendienteServiceImplementation implements ICobroPendienteService{
    
    @Autowired ICobroPendienteRepository cobroRepository;

    @Override
    @Transactional(readOnly = true)
    public Optional<CobroPendienteDTO> findById(Long id) {
        return ServiceConvertionHelper.OptionalOneToOptionalDto(cobroRepository.findById(id), CobroPendienteDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<CobroPendienteDTO>> findByCliente(Long id) {
        return ServiceConvertionHelper.findList(cobroRepository.findByCliente(id), CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public CobroPendienteDTO create(CobroPendienteDTO cobro) {
        CobroPendiente entidad = MapperUtils.EntityFromDto(cobro, CobroPendiente.class);
        entidad = cobroRepository.save(entidad);
        return MapperUtils.DtoFromEntity(entidad, CobroPendienteDTO.class);
    }

    @Override
    @Transactional
    public void deleteAll() {
        cobroRepository.deleteAll();
    }
    
}
