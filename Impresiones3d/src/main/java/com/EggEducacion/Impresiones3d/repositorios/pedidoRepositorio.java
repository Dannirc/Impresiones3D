package com.EggEducacion.Impresiones3d.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EggEducacion.Impresiones3d.entidades.Pedido;


@Repository
public interface PedidoRepositorio extends JpaRepository<Pedido, String> {

}
