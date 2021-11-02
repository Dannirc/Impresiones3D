package com.EggEducacion.Impresiones3d.servicios;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EggEducacion.Impresiones3d.entidades.Cliente;
import com.EggEducacion.Impresiones3d.entidades.Pedido;
import com.EggEducacion.Impresiones3d.entidades.Producto;
import com.EggEducacion.Impresiones3d.repositorios.PedidoRepositorio;


@Service
public class PedidoServicio {
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	
	
	@Transactional
	public Pedido crearPedido(String id, Producto producto, Cliente cliente, Date fecha) throws Exception {
		Pedido pedido = new Pedido();
		pedido.setId(id);
		pedido.setProducto(producto);
		pedido.setCliente(cliente);
		pedido.setFecha(fecha);
		return pedidoRepositorio.save(pedido);
	}
	
	@Transactional
	public void modificarPedido(String id, Producto producto, Cliente cliente, Date fecha) throws Exception {
		Optional<Pedido> respuesta = pedidoRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Pedido pedido = respuesta.get();
			pedido.setId(id);
			pedido.setProducto(producto);
			pedido.setCliente(cliente);
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
	
}