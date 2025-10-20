package com.tecsup.services;

import com.tecsup.model.daos.AlumnoRepository;
import com.tecsup.model.entities.Alumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    private AlumnoRepository dao;

    @Override
    public List<Alumno> findAllStudent() {
        return (List<Alumno>) dao.findAll();
    }

    @Override
    public Alumno findByIdStudent(int id) {
        return dao.findById(id).orElse(null);
    }

    @Override
    public void saveStudent(Alumno alumno) {
        dao.save(alumno);

    }

    @Override
    public void deleteStudent(int id) {
        dao.deleteById(id);
    }

    @Override
    public List<Alumno> searchByStudent(String nombre) {
        return dao.findByNombreContainingIgnoreCase(nombre);
    }

}
