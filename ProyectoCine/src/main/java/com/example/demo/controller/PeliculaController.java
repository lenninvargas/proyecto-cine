package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Pelicula;
import com.example.demo.service.PeliculaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PeliculaController {

	@Autowired
	private PeliculaService peliculaService;
	
	@GetMapping("/registrar_pelicula")
	public String showRegistrarUsuario(Model model, HttpSession session) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
		model.addAttribute("pelicula", new Pelicula());
		return "/pelicula/registrar_pelicula";
	}
	
	@PostMapping("/registrar_pelicula")
	public String registrarUsuario(HttpSession session, Pelicula pelicula, Model model,
			@RequestParam("foto")MultipartFile foto) {
		if(session.getAttribute("empleado") == null) {
			return "redirect:/";
		}
	
		peliculaService.crearPelicula(pelicula, model, foto);
		return "/pelicula/registrar_pelicula";
	}
}
