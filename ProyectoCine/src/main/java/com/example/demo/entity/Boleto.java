package com.example.demo.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "TB_BOLETO")
public class Boleto {

	@Id
	@Column(name = "id_boleto")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBoleto;
	
	private double precio = 16.00;
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date fecha;
	
	@Column(nullable = false, length = 10)
	private String asiento;
	
	@ManyToOne
	@JoinColumn(name = "id_funcion" , nullable = false)
	private Funcion idFuncion;
	
}