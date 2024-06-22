package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TB_BOLETO")
public class Boleto {

	@Id
	@Column(name = "id_boleto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBoleto;
	
	@Column(name = "precio", nullable = false, precision = 10, scale=2)
	private BigDecimal precio;
	
	@Column(name = "fecha", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fecha;
	
	@Column(name = "cliente", nullable = false)
	private Integer cliente;
	
	@Column(name = "asiento", nullable = false, length = 10)
	private String asiento;
	
	@ManyToOne
	@JoinColumn(name = "id_funcion" , nullable = false)
	private Funcion idFuncion;
	
	@ManyToOne
	@JoinColumn(name = "id_empleado" , nullable = false)
	private Empleado idEmpleado;
	
	
}