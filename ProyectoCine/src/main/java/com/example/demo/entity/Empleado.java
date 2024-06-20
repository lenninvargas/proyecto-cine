package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "TB_EMPLEADO")
public class Empleado {

	@Id
	@Column(name = "id_empleado", nullable = false, unique = true)
	private Integer idEmpleado;
	
	@Column(name = "nombre_empleado", nullable = false, length = 50)
	private String nomEmpleado;
	
	@Column(name = "apellido_empleado", nullable = false, length = 50)
	private String apeEmpleado;
	
	@Column (name = "dni", nullable = false ,columnDefinition = "CHAR(8)", length = 8)
	private String dni;
	
	@ManyToOne
	@JoinColumn(name = "id_tiipo" , nullable = false)
	private Tipo_Empleado idTipo;
	
}
