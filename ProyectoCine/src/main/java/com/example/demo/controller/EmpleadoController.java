package com.example.demo.controller;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> a6e9092fd1a0646cd06909a1eab76b8eb3d4b882
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Empleado;
import com.example.demo.entity.TipoEmpleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.repository.TypeEmpleadoRepository;
=======
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import jakarta.servlet.http.HttpSession;
>>>>>>> a6e9092fd1a0646cd06909a1eab76b8eb3d4b882

@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
<<<<<<< HEAD
	@Autowired
	private TypeEmpleadoRepository typeRepository;
	
	
	@GetMapping("/empleados")
	public String home(Model model) {
		List<Empleado> listarEmpleados = empleadoRepository.findAll();
		model.addAttribute("listarEmpleado", listarEmpleados);
		
		return "empleadoLista";
	}
	
	
	@GetMapping("/registrar_empleado")
	public String showRegistrarEmpleado(Model model) {
		List<TipoEmpleado> listarTipo = typeRepository.findAll();
		model.addAttribute("empleado", new Empleado());
		model.addAttribute("listarTipo", listarTipo);
		
		return "registrar_empleado";
		
	}
	
	
	@PostMapping("/registrar_empleado")
	public String registrarEmpleado(@ModelAttribute Empleado empleado, Model model) {
		empleadoRepository.save(empleado);
		
		return  "redirect:/empleados";
	}
	
	

	@GetMapping("/editar_empleado/{id}")
	public String showeditarEmpleado(Model model, @PathVariable("id") Integer id) {
		Empleado encontrarEmpleado = empleadoRepository.findById(id).get();
		List<TipoEmpleado> listarTipo = typeRepository.findAll();
		model.addAttribute("listarTipo", listarTipo);
		model.addAttribute("empleado", encontrarEmpleado);
		
		return "editar_empleado";	
	}
	
		

	@GetMapping("/eliminar_empleado/{id}")
	public String eliminarEmpleado(@PathVariable("id") Integer id) {
		
		empleadoRepository.deleteById(id);
		
		return "redirect:/empleados";
	}
	

}	
=======
	
	
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
>>>>>>> a6e9092fd1a0646cd06909a1eab76b8eb3d4b882
