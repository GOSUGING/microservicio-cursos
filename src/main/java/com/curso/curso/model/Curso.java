package com.curso.curso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nombreCurso;

    @Column(nullable = true)
    private String descripcionCurso;

    @Column(nullable = false)
    
    private Date duracionCurso;

    @Column(nullable = false)
    private String estadoCurso;


    //Acá van las relaciones a las otras tablas

}
