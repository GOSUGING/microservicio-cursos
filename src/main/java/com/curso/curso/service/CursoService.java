package com.curso.curso.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.curso.model.Curso;
import com.curso.curso.model.EstadoCurso;
import com.curso.curso.repository.CursoRepository;



import jakarta.transaction.Transactional;

@Service
@Transactional
public class CursoService {
    
    
    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EstadoCursoService estadoCursoService; // Inyectar el servicio de EstadoCurso si es necesario
    // Puedes agregar más servicios según sea necesario
    
    
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

     public Curso save(Curso curso) {
        // Ejemplo: validar que el estado existe antes de guardar el curso
        Integer estadoId = curso.getEstadoCurso().getId(); // asumiendo relación ManyToOne
        EstadoCurso estado = estadoCursoService.findById(estadoId);

        if (estado == null) {
            throw new RuntimeException("Estado no válido: " + estadoId);
        }

        // establecer estado actualizado en el curso (opcional si ya viene bien)
        curso.setEstadoCurso(estado);

        return cursoRepository.save(curso);
    }

    public void delete(Integer id) {
        cursoRepository.deleteById(id);
    }



    
}
