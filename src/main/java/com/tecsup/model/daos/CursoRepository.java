package com.tecsup.model.daos;

import com.tecsup.model.entities.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface CursoRepository extends MongoRepository<Curso, String> {

    List<Curso> findByNombreContainingIgnoreCase(String nombre);

}
