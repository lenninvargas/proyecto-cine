package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "TB_TIPO_EMPLEADO")
public class Tipo_Empleado {
	@Id
	@Column(name = "id_tipo", nullable = false, unique = true)
	private Integer idTipo;
	
	@Column(name = "nombre_tipo", nullable = false)
	private String nombTipo;
}
