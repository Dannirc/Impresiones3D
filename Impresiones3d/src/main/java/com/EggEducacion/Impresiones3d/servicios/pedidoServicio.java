package com.EggEducacion.Impresiones3d.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EggEducacion.Impresiones3d.entidades.Usuario;
import com.EggEducacion.Impresiones3d.entidades.Pedido;
import com.EggEducacion.Impresiones3d.entidades.Producto;
import com.EggEducacion.Impresiones3d.repositorios.pedidoRepositorio;


@Service
public class pedidoServicio {
	@Autowired
	private pedidoRepositorio pedidoRepositorio;
	
	
	@Transactional
	public Pedido crearPedido(String id, Producto producto, Usuario usuario, Date fecha) throws Exception {
		validar(producto, usuario, fecha);
		Pedido pedido = new Pedido();
		pedido.setId(id);
		pedido.setProducto(producto);
		pedido.setCliente(usuario);
		pedido.setFecha(fecha);
		return pedidoRepositorio.save(pedido);
	}
	
	@Transactional
	public void modificarPedido(String id, Producto producto, Usuario usuario, Date fecha) throws Exception {
		Optional<Pedido> respuesta = pedidoRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Pedido pedido = respuesta.get();
			pedido.setId(id);
			pedido.setProducto(producto);
			pedido.setCliente(usuario);
			pedido.setFecha(fecha);
			pedidoRepositorio.save(pedido);
		} else {
			throw new Exception("error en el modificar-pedido");
		}
	}
	
	@Transactional
	public List<Pedido> listarTodos() {
		return pedidoRepositorio.findAll();
	}
	
	public void validar(Producto producto, Usuario usuario, Date fecha) throws Exception {

		if (producto == null) {
			throw new Exception("Debe tener un producto valido");
		}
		
		if (usuario == null) {
			throw new Exception("Debe tener un usuario valido");
		}	
		
		if (fecha == null) {
			throw new Exception("Debe tener una fecha valida");
		}

	}
	
}