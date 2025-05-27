package com.curso.curso.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estado_curso")
@Data
@NoArgsConstructor  
@AllArgsConstructor

public class EstadoCurso {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private StatusCursoEnum status;

    @OneToMany(mappedBy = "estadoCurso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore // si decides exponer este modelo como respuesta directamente
    private List<Curso> cursos;

}
