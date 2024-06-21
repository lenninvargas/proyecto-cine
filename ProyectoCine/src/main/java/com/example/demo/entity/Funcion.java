package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_FUNCION")
public class Funcion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcion")
	private Integer idFuncion;
	
	@ManyToOne
	@JoinColumn(name = "id_pelicula" , nullable = false)
	private Pelicula idPelicula;
	
	@ManyToOne
	@JoinColumn(name = "id_sala" , nullable = false)
	private Sala idSala;
	
	@ManyToOne
	@JoinColumn(name = "id_horario" , nullable = false)
	private Horario idHorario;
	
}