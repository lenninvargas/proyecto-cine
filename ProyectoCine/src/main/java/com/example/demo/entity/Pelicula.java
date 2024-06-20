package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "TB_PELICULA")
public class Pelicula {

	@Id
	@Column(name = "id_pelicula")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPelicula;
	
	@Column(name = "nombre_pelicula", nullable = false, length = 40)
	private	String nomPelicula;
	
	
}
