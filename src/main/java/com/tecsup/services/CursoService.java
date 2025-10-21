package com.tecsup.services;


import com.tecsup.model.entities.Curso;
import java.util.List;


public interface CursoService{
    public List<Curso> findAllCourse();
    public Curso findByIdCourse(String id);
    public void saveCourse(Curso curso);
    public void deleteCourse(String id);
    List<Curso> searchByNombre(String nombre);

}
