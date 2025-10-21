package com.tecsup.model.entities;

import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "alumnos")
public class Alumno {

    @Id
    private String id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String dni;
    
    @NotNull
    private String email;
    
    @NotNull
    private String telefono;

    public Alumno() {

    }
    public Alumno(String id, String nombre, String dni, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String  nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    public void  setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", dni=" + dni +
                ", email=" + email +
                ", telefono=" + telefono +
                '}';
    }
}
