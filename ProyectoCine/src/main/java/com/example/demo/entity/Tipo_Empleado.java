package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "TB_TIPO_EMPLEADO")
public class Tipo_Empleado {
	@Id
	@Column(name = "id_tipo", nullable = false, unique = true)
	private Integer idTipo;
	
	@Column(name = "nombre_tipo", nullable = false)
	private String nombTipo;
}
