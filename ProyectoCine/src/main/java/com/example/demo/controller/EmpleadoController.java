package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.TipoEmpleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.TypeEmpleadoRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private TypeEmpleadoRepository typeRepository;
	
	
	@GetMapping("/empleados")
	public String home(Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		List<Empleado> listarEmpleados = empleadoRepository.findAll();
		model.addAttribute("listarEmpleado", listarEmpleados);
		
		return "empleadoLista";
	}
	
	
	@GetMapping("/registrar_empleado")
	public String showRegistrarEmpleado(Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		List<TipoEmpleado> listarTipo = typeRepository.findAll();
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("listarTipo", listarTipo);
		
		return "registrar_empleado";
		
	}
	
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute Empleado empleado, Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		empleadoRepository.save(empleado);
		
		return  "redirect:/empleados";
	}
	
	

	@GetMapping("/editar_empleado/{id}")
	public String showeditarEmpleado(Model model, @PathVariable("id") Integer id, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		Empleado encontrarEmpleado = empleadoRepository.findById(id).get();
		List<TipoEmpleado> listarTipo = typeRepository.findAll();
		model.addAttribute("listarTipo", listarTipo);
		model.addAttribute("empleado", encontrarEmpleado);
		
		return "editar_empleado";	
	}
	
		

	@GetMapping("/eliminar_empleado/{id}")
	public String eliminarEmpleado(@PathVariable("id") Integer id, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		empleadoRepository.deleteById(id);
		
		return "redirect:/empleados";
	}
	
}	

