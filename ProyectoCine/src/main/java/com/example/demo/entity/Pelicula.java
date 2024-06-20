package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_PELICULA")
public class Pelicula {

	@Id
	@Column(name = "id_pelicula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPelicula;
	
	@Column(name = "nombre_pelicula", nullable = false, length = 40)
	private	String nomPelicula;
	
	
}
