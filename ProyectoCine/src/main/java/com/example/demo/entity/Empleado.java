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
@Table(name = "TB_EMPLEADO")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado", nullable = false)
	private Integer idEmpleado;
	
	@Column(name = "nombre_empleado", nullable = false, length = 50)
	private String nomEmpleado;
	
	@Column(name = "apellido_empleado", nullable = false, length = 50)
	private String apeEmpleado;
	
	@Column (name = "dni", nullable = false ,columnDefinition = "CHAR(8)", length = 8)
	private String dni;
	
	@Column (name = "correo", nullable = false, length = 50)
	private String correo;
	
	@Column (name = "password", nullable = false, length = 50)
	private String contrasenia;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo" , nullable = false)
	private TipoEmpleado idTipo;
	
}
