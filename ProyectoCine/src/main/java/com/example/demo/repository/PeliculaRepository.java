package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula,Integer> {

}
