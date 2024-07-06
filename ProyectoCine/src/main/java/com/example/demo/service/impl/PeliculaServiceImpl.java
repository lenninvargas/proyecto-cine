package com.example.demo.service.impl;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.Pelicula;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.service.PeliculaService;
import com.example.demo.utils.Utilitarios;

@Service
public class PeliculaServiceImpl implements PeliculaService{

	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Override
	public void crearPelicula(Pelicula pelicula, Model model, MultipartFile foto) {
		String nombreFoto = Utilitarios.guardarImagen(foto);
		pelicula.setUrlImagen(nombreFoto);
		
		//guardar usuario
		peliculaRepository.save(pelicula);
		
		if(pelicula!=null) {
			try {
				File saveFile = new ClassPathResource("static/pelicula_foto").getFile();
				Path path = Paths.get(saveFile.getAbsolutePath()+File.separator+foto.getOriginalFilename());
				
				Files.copy(foto.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		
		//responder a la vista
		model.addAttribute("registroCorrecto", "Registro Correcto");
		model.addAttribute("pelicula", new Pelicula());
		
	}

}
