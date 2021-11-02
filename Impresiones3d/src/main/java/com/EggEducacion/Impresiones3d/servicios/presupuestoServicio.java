package com.EggEducacion.Impresiones3d.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EggEducacion.Impresiones3d.entidades.Pedido;
import com.EggEducacion.Impresiones3d.entidades.Presupuesto;
import com.EggEducacion.Impresiones3d.repositorios.PresupuestoRepositorio;


@Service
public class PresupuestoServicio {
	@Autowired
	private PresupuestoRepositorio PresupuestoRepositorio;
	
	
	@Transactional
	public Presupuesto crearPresupuesto(String id, Pedido pedido, Float precio, Integer plazoEntrega) throws Exception {
		Presupuesto presupuesto = new Presupuesto();
		presupuesto.setId(id);
		presupuesto.setPedido(pedido);
		presupuesto.setPrecio(precio);
		return PresupuestoRepositorio.save(presupuesto);
	}
	
	@Transactional
	public void modificarPresupuesto(String id, Pedido pedido, Float precio, Integer plazoEntrega) throws Exception {
		Optional<Presupuesto> respuesta = PresupuestoRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Presupuesto presupuesto = respuesta.get();
			presupuesto.setId(id);
			presupuesto.setPedido(pedido);
			presupuesto.setPrecio(precio);
			PresupuestoRepositorio.save(presupuesto);
		} else {
			throw new Exception("error en el modificar-presupuesto");
		}
	}
	
	@Transactional
	public List<Presupuesto> listarTodos() {
		return PresupuestoRepositorio.findAll();
	}
	
}