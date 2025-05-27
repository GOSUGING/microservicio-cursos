package com.curso.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.curso.model.EstadoCurso;
import com.curso.curso.model.StatusCursoEnum;
import com.curso.curso.repository.EstadoCursoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EstadoCursoService {
    @Autowired  
    private EstadoCursoRepository estadoCursoRepository;
    
    public List<EstadoCurso> findAll() {
        return estadoCursoRepository.findAll();
    }

    public EstadoCurso findById(Integer id) {
        return estadoCursoRepository.findById(id).orElse(null);
    }

    public EstadoCurso save(EstadoCurso estadoCurso) {
        return estadoCursoRepository.save(estadoCurso);
    }

    public void delete(Integer id) {
        estadoCursoRepository.deleteById(id);
    }
    

    public EstadoCurso findByStatus(StatusCursoEnum status) {
        return estadoCursoRepository.findByStatus(status);
    }
    

}
