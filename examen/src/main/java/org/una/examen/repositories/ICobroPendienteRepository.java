/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.una.examen.entities.CobroPendiente;

public interface ICobroPendienteRepository extends JpaRepository<CobroPendiente, Long>{
    
    @Query("Select cp from CobroPendiente cp Where cp.cliente.id = :id")
    public List<CobroPendiente> findByCliente(@Param("id") Long id);
}
