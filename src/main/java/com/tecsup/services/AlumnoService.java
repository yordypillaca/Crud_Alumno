package com.tecsup.services;

import com.tecsup.model.entities.Alumno;

import java.util.List;

public interface AlumnoService {

    public List<Alumno> findAllStudent();
    public Alumno findByIdStudent(int id);
    public void saveStudent(Alumno alumno);
    public void deleteStudent(int id);
    List<Alumno> searchByStudent(String nombre);

}
