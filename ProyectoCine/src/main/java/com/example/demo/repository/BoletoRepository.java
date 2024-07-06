package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Boleto;
import com.example.demo.entity.Funcion;

import jakarta.transaction.Transactional;

@Repository
public interface BoletoRepository extends JpaRepository<Boleto, Integer>{
	String findByAsiento(String asiento);
	Boleto findByIdBoleto(Integer idBoleto);
}
