/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.examen.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "exa_dbf_membresias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Membresia implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Float monto;
    
    @Column(name = "descripcion",length = 100)
    private String descripcion;
    
    @Column(columnDefinition="TINYINT")
    private Integer periodicidad;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "membresia")
    private List<CobroPendiente> cobros;
    
}
