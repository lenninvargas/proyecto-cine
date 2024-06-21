package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.entity.Funcion;
import com.example.demo.repository.FuncionRepository;

@Controller
public class FuncionController {
	@Autowired
	private FuncionRepository repository;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Funcion> listaFuncion = repository.findAll();
		model.addAttribute("listaFuncion",listaFuncion);
		return "funcionLista";
	}
}
