package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SALA")
public class Sala {
	@Id
	@Column(name = "id_sala")
	private Integer idSala;
	
	@Column(name = "nombre_sala", nullable = false, unique = true,length = 30)
	private String nomSala;
	
	
}
