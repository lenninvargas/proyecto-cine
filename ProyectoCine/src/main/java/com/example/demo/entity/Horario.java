package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TB_HORARIO")
public class Horario {

	@Id
	@Column(name = "id_horario", nullable = false)
	private Integer idHorario;
	
	@Column(name = "hora", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	
}
