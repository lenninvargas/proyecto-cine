package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "TB_HORARIO")
public class Horario {

	@Id
	@Column(name = "id_horario", nullable = false)
	private Integer idHorario;
	
	@Column(name = "hora", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date hora;
	
	
}
