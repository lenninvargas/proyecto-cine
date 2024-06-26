package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.*;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	Empleado findByCorreoAndContrasenia(String correo, String contrasenia);
}
