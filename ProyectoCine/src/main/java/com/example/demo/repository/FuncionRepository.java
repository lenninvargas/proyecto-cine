package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entity.Funcion;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface FuncionRepository extends JpaRepository<Funcion,Integer> {

}
