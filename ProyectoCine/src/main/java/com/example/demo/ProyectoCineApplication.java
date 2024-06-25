package com.example.demo;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.Horario;
import com.example.demo.entity.Pelicula;
import com.example.demo.entity.Sala;
import com.example.demo.repository.HorarioRepository;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.SalaRepository;

@SpringBootApplication
public class ProyectoCineApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoCineApplication.class, args);
		
	}

}
