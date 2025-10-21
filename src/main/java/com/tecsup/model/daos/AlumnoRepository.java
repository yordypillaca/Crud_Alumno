package com.tecsup.model.daos;

import com.tecsup.model.entities.Alumno;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AlumnoRepository extends MongoRepository<Alumno, String> {

    List<Alumno> findByNombreContainingIgnoreCase(String nombre);

}
