package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import jakarta.servlet.http.HttpSession;

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin(Model model) {
		model.addAttribute("empleado",new Empleado());
		return "login";
	}
	
	
	@PostMapping("/login")
	public String login(@ModelAttribute Empleado empleado, Model model, HttpSession session) {
	    Empleado empleadoEncontrado = empleadoRepository
	            .findByCorreoAndContrasenia(empleado.getCorreo(), empleado.getContrasenia());
	    if (empleadoEncontrado != null) {        
	        session.setAttribute("empleado", empleadoEncontrado.getCorreo());
	        session.setAttribute("tipoEmpleado", empleadoEncontrado.getIdTipo().getNombTipo());
	        if (empleadoEncontrado.getIdTipo().getNombTipo().equalsIgnoreCase("cajero")) {
	            return "redirect:/menuCajero";
	        } else if (empleadoEncontrado.getIdTipo().getNombTipo().equalsIgnoreCase("administrador")) {
	            return "redirect:/menuAdministrador";
	        } else {
	            model.addAttribute("loginIncorrecto", "Tipo de empleado no reconocido");
	            model.addAttribute("empleado", new Empleado());
	            return "login";
	        }
	    } else {
	        model.addAttribute("loginIncorrecto", "Este empleado no existe");
	        model.addAttribute("empleado", new Empleado());
	        return "login";
	    }
	}

	
	@GetMapping("/menuCajero")
	public String showMenuCajero(Model model, HttpSession session) {
		String correoString = (String)session.getAttribute("empleado");
		if(correoString == null) {
			return "return:/login";
		}
		model.addAttribute("correo", session.getAttribute("empleado"));
		return "menuCajero";
	}
	
	
	@GetMapping("/menuAdministrador")
	public String showMenuAdministrador(Model model, HttpSession session) {
		String correoString = (String)session.getAttribute("empleado");
		if(correoString == null) {
			return "return:/login";
		}
		model.addAttribute("correo", session.getAttribute("empleado"));
		return "menuAdministrador";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
