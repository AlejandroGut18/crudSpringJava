package com.evaluacion.crud.dominio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaiyanEntity {
    private long id;
    private String nombre;
    private String fase;
    private String arteMarcial;
    private float poder;

}
