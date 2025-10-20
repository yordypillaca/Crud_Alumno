package com.tecsup.controller;

import com.tecsup.model.entities.Curso;
import com.tecsup.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cursos")
@SessionAttributes("curso")
public class CursoController {

    @Autowired
    private CursoService servicio;

    //REDIRIGIR A LISTAR
    @GetMapping({"", "/"})
    public String index() {
        return "redirect:/cursos/listar";
    }

    //LISTADO
    @GetMapping("/listar")
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de Cursos");
        model.addAttribute("cursos", servicio.findAllCourse());
        return "listView"; //
    }
    //CREAR
    @GetMapping("/form")
    public String crear(Model model) {
        Curso curso = new Curso();
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Formulario de Curso");
        return "formView"; // Nombre de la plantilla HTML del formulario
    }

    // Mostrar formulario con datos existentes para editar
    @GetMapping("/form/{id}")
    public String editar(@PathVariable("id") int id, Model model) {
        Curso curso = servicio.findByIdCourse(id);
        model.addAttribute("curso", curso);
        model.addAttribute("titulo", "Editar Curso");
        return "formView"; // mismo formulario que para crear
    }

    @PostMapping("/form")
    public String guardar(@Valid Curso curso, BindingResult result) {
        if (result.hasErrors()) {
            return "formView";
        }
        servicio.saveCourse(curso);
        return "redirect:/cursos/listar";
    }

    // Eliminar un curso por id
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") int id) {
        servicio.deleteCourse(id);
        return "redirect:/cursos/listar";
    }

    @GetMapping("/buscar")
    public String buscarCurso(String palabraClave, Model model) {
        List<Curso> cursos;

        if (palabraClave != null && !palabraClave.isEmpty()) {
            cursos = servicio.searchByNombre(palabraClave);
        } else {
            cursos = servicio.findAllCourse();
        }

        model.addAttribute("titulo", "Resultados de búsqueda");
        model.addAttribute("cursos", cursos);
        return "listView";
    }




}
