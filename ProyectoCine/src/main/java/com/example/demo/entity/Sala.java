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
@Table(name = "TB_SALA")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Sala {
	
<<<<<<< HEAD
=======

>>>>>>> a28b38f74ad7813d55c00daa75f0e24520d97a04
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_sala")
	private Integer idSala;
	
	@Column(name = "nombre_sala", nullable = false, unique = true,length = 30)
	private String nomSala;
	

	public Sala(String nomSala) {
		this.nomSala= nomSala;
	}

	
	
}