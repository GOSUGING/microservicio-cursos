package com.curso.curso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.curso.model.EstadoCurso;
import com.curso.curso.model.StatusCursoEnum;

public interface EstadoCursoRepository extends JpaRepository<EstadoCurso, Integer> {
    
    EstadoCurso findByStatus(StatusCursoEnum status);    

}
