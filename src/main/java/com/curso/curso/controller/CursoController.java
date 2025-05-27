package com.curso.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.curso.model.Curso;
import com.curso.curso.model.EstadoCurso;
import com.curso.curso.model.StatusCursoEnum;
import com.curso.curso.service.CursoService;
import com.curso.curso.service.EstadoCursoService;

@RestController
@RequestMapping("/api/v1/cursos")
public class CursoController {

    @Autowired
    private EstadoCursoService estadoCursoService;

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> listar() {
        List<Curso> cursos = cursoService.findAll();
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursos);
    }

    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso) {
        if (curso.getEstadoCurso() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Curso nuevoCurso = cursoService.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerPorId(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        if (curso.isPresent()) {
            return ResponseEntity.ok(curso.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public Curso actualizar(@PathVariable Integer id, @RequestBody Curso curso) {
        curso.setId(id);
        return cursoService.save(curso);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        cursoService.delete(id);
    }

    @GetMapping("/estado/{status}")
    public ResponseEntity<List<Curso>> buscarPorEstado(@PathVariable StatusCursoEnum status) {
        EstadoCurso estadoCurso = estadoCursoService.findByStatus(status);

        if (estadoCurso == null) {
            return ResponseEntity.notFound().build();
        }

        List<Curso> cursos = estadoCurso.getCursos();

        if (cursos == null || cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(cursos);
    }

}
