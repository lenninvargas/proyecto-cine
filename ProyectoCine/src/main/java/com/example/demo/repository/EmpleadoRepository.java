package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<< HEAD
import com.example.demo.entity.*;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	
	
	

=======
import com.example.demo.entity.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	Empleado findByCorreoAndContrasenia(String correo, String contrasenia);
>>>>>>> a6e9092fd1a0646cd06909a1eab76b8eb3d4b882
}
