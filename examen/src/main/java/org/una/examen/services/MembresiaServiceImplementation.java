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
import org.una.examen.dto.MembresiaDTO;
import org.una.examen.repositories.IMembresiaRepository;
import org.una.examen.utils.MapperUtils;
import org.una.examen.utils.ServiceConvertionHelper;
import org.una.examen.entities.Membresia;

@Service
public class MembresiaServiceImplementation implements IMembresiaService{
    
    @Autowired
    IMembresiaRepository membresiaRepository;    

    @Override
    @Transactional(readOnly = true)
    public Optional<MembresiaDTO> findById(Long id) {
        return ServiceConvertionHelper.OptionalOneToOptionalDto(membresiaRepository.findById(id), MembresiaDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<MembresiaDTO>> findAll() {
        return ServiceConvertionHelper.findList(membresiaRepository.findAll(), MembresiaDTO.class);
    }
    
    @Override
    public MembresiaDTO create(MembresiaDTO membresia) {
        Membresia entidad = MapperUtils.EntityFromDto(membresia, Membresia.class);
        entidad = membresiaRepository.save(entidad);
        return MapperUtils.DtoFromEntity(entidad, MembresiaDTO.class);
    }
    
}
