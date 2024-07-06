package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Boleto;
import com.example.demo.repository.BoletoRepository;
import com.example.demo.service.BoletoService;

@Service
public class BoletoServiceImpl implements BoletoService {

	@Autowired
	BoletoRepository boletoRepository;

	@Override
	public List<String> obtenerAsientos(Integer funId, Integer salId, Integer horaId) {
		// Obtengo todos los boletos guardados
		List<Boleto> boletos = boletoRepository.findAll();

		// Creo una lista para obtener los asientos guardados en el boleto
		List<String> asientos = new ArrayList<String>();
		for (int i = 0; i < boletos.size(); i++) {
			if (boletos.get(i).getIdFuncion().getIdFuncion() == funId
					&& boletos.get(i).getIdFuncion().getIdHorario().getIdHorario() == horaId
					&& boletos.get(i).getIdFuncion().getIdSala().getIdSala() == salId) {
				asientos.add(boletos.get(i).getAsiento());
			}
		}
		// Ordeno la lista de asientos
		Collections.sort(asientos);
		return asientos;
	}

	@Override
	public List<Boleto> obtenerTodosBoletos() {
		return boletoRepository.findAll();
	}

	@Override
	public Boleto guardarBoleto(Boleto boleto) {
		return boletoRepository.save(boleto);
	}

}
