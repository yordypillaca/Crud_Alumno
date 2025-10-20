package com.tecsup.controller;

import com.tecsup.model.entities.Alumno;
import com.tecsup.services.AlumnoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/alumnos")
@SessionAttributes("alumno")
public class AlumnoController {

    @Autowired
    private AlumnoService servicio;

    //REDIRIGIR A LISTAR
    @GetMapping({"", "/"})
    public String index() {
        return "redirect:/alumnos/listar";
    }

    //LISTADO
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Alumnos");
        model.addAttribute("alumnos", servicio.findAllStudent());
        return "listViewAlumno"; //
    }
    //CREAR
    @GetMapping("/form")
    public String crear(Model model) {
        Alumno alumno = new Alumno();
        model.addAttribute("alumno", alumno);
        model.addAttribute("titulo", "Formulario de Alumno");
        return "formViewAlumno"; // Nombre de la plantilla HTML del formulario
    }

    // Mostrar formulario con datos existentes para editar
    @GetMapping("/form/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Alumno alumno = servicio.findByIdStudent(id);
        model.addAttribute("alumno", alumno);
        model.addAttribute("titulo", "Editar Alumno");
        return "formViewAlumno"; // mismo formulario que para crear
    }

    @PostMapping("/form")
    public String guardar(@Valid Alumno alumno, BindingResult result) {
        if (result.hasErrors()) {
            return "formViewAlumno"; // Si hay errores, vuelve al formulario
        }
        servicio.saveStudent(alumno); // Crea o actualiza según el id
        return "redirect:/alumnos/listar";
    }

    @GetMapping("/eliminar/{id}")
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable("id") int id) {
        servicio.deleteStudent(id); // Llama al servicio que ya tienes
        return "redirect:/alumnos/listar"; // Redirige al listado después de eliminar
    }

    @GetMapping("/buscar")
    public String buscarAlumno(String palabraClave, Model model) {
        List<Alumno> alumnos;

        if (palabraClave != null && !palabraClave.isEmpty()) {
            alumnos = servicio.searchByStudent(palabraClave);
        } else {
            alumnos = servicio.findAllStudent(); // si no hay palabra, mostrar todos
        }

        model.addAttribute("titulo", "Resultados de búsqueda");
        model.addAttribute("alumnos", alumnos);
        return "listViewAlumno";
    }
}
