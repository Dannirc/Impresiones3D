package com.EggEducacion.Impresiones3d.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EggEducacion.Impresiones3d.entidades.Cliente;


@Repository
public interface clienteRepositorio extends JpaRepository<Cliente, String> {

}
