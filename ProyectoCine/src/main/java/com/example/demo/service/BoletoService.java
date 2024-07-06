package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Boleto;

public interface BoletoService {
	List<String> obtenerAsientos(Integer funId, Integer salId, Integer horaId);
	List<Boleto> obtenerTodosBoletos();
	Boleto guardarBoleto(Boleto boleto);
}
