package com.example.demo.data;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Pelicula;
import com.example.demo.entity.Sala;
import com.example.demo.entity.Horario;
import com.example.demo.repository.PeliculaRepository;
import com.example.demo.repository.SalaRepository;
import com.example.demo.repository.HorarioRepository;

@Component
public class DataLoader implements CommandLineRunner {

	//Insertar datos aun con CREATE en properties
	
    @Autowired
    private PeliculaRepository peliculaRepository;

    @Autowired
    private SalaRepository salaRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Insertar datos iniciales en Pelicula
        Pelicula pelicula1 = new Pelicula("Avengers");
        Pelicula pelicula2 = new Pelicula("Intensamente 2");
        Pelicula pelicula3 = new Pelicula("Asu mare");
        Pelicula pelicula4 = new Pelicula("Paddington");
        peliculaRepository.save(pelicula1);
        peliculaRepository.save(pelicula2);
        peliculaRepository.save(pelicula3);
        peliculaRepository.save(pelicula4);

        // Insertar datos iniciales en Sala
        Sala sala1 = new Sala("Sala 1");
        Sala sala2 = new Sala("Sala 2");
        Sala sala3 = new Sala("Sala 3");
        Sala sala4 = new Sala("Sala 4");
        salaRepository.save(sala1);
        salaRepository.save(sala2);
        salaRepository.save(sala3);
        salaRepository.save(sala4);


        // Insertar datos iniciales en Horario
        Horario horario1 = new Horario(LocalTime.of(10, 0));
        Horario horario2 = new Horario(LocalTime.of(14, 0));
        horarioRepository.save(horario1);
        horarioRepository.save(horario2);
    }
}