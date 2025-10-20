package com.tecsup.model.daos;

import com.tecsup.model.entities.Alumno;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlumnoRepository extends CrudRepository<Alumno, Integer> {

    List<Alumno> findByNombreContainingIgnoreCase(String nombre);

}
