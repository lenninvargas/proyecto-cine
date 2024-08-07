package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Funcion;
import com.example.demo.entity.Horario;
import com.example.demo.entity.Pelicula;
import com.example.demo.entity.Sala;
import com.example.demo.repository.FuncionRepository;
import com.example.demo.repository.HorarioRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.SalaRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class FuncionController {
	@Autowired
	private FuncionRepository repositoryFuncion;
	@Autowired
	private PeliculaRepository repositoryPelicula;
	@Autowired
	private SalaRepository repositorySala;
	@Autowired
	private HorarioRepository repositoryHorario;
	
	@GetMapping("/funciones")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		List<Funcion> listaFuncion = repositoryFuncion.findAll();
		model.addAttribute("listaFuncion",listaFuncion);
		
		return "funcionLista";
	}
	
	@GetMapping("/registrar_funcion")
	public String showRegistrarFuncion(Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		model.addAttribute("funcion", new Funcion());
		
		List<Pelicula> listaPeliculas = repositoryPelicula.findAll();
	    List<Sala> listaSalas = repositorySala.findAll();
	    List<Horario> listaHorarios = repositoryHorario.findAll();
	    

        model.addAttribute("listaPeliculas", listaPeliculas);
        model.addAttribute("listaSalas", listaSalas);
        model.addAttribute("listaHorarios", listaHorarios);
		return "registroFuncion";
	}
	
	@PostMapping("/registrar_funcion")
	public String registrarFuncion(@ModelAttribute Funcion funcion, Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
	    repositoryFuncion.save(funcion);
		return "redirect:/funciones";
	}
	
	@GetMapping("/editar_funcion/{id}")
	public String mostrarFormularioEdicion(Model model, @PathVariable("id") Integer id, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
	    Funcion funcionActualizar = repositoryFuncion.findById(id).get();
	    List<Pelicula> listaPeliculas = repositoryPelicula.findAll();
	    List<Sala> listaSalas = repositorySala.findAll();
	    List<Horario> listaHorarios = repositoryHorario.findAll();

	    model.addAttribute("funcion", funcionActualizar);
	    model.addAttribute("listaPeliculas", listaPeliculas);
	    model.addAttribute("listaSalas", listaSalas);
	    model.addAttribute("listaHorarios", listaHorarios);

	    return "actualizarFuncion";
	}
	
	@PostMapping("/editar_funcion")
	public String actualizarFuncion(@ModelAttribute Funcion funcion, Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		repositoryFuncion.save(funcion);
	    return "redirect:/funciones";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminarFuncion(@PathVariable("id")Integer id, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		repositoryFuncion.deleteById(id);
		return "redirect:/funciones";
	}
	
	@GetMapping("/escoger_funcion")
	public String showEscogerFuncion(HttpSession session, Model model) {
		if(session.getAttribute("empleado") == null) {
			System.out.println("La sesión se cerró");
			return "redirect:/";
		}
		
		List<Funcion> funciones = repositoryFuncion.findAll();
		model.addAttribute("funciones", funciones);		
											
		return "escoger_funcion";
	}
	
}
