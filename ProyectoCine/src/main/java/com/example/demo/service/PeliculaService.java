package com.example.demo.service;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Pelicula;

public interface PeliculaService {
	void crearPelicula(Pelicula pelicula, Model model, MultipartFile foto);
}
