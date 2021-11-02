package com.EggEducacion.Impresiones3d.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EggEducacion.Impresiones3d.entidades.Cliente;
import com.EggEducacion.Impresiones3d.repositorios.clienteRepositorio;


@Service
public class clienteServicio {
	@Autowired
	private clienteRepositorio clienteRepositorio;
	
	
	@Transactional
	public Cliente crearCliente(String id, String nombre, String direccion, String email, String telefono, String clave) throws Exception {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		cliente.setNombre(nombre);
		cliente.setClave(clave);
		cliente.setDireccion(direccion);
		cliente.setTelefono(telefono);
		cliente.setEmail(email);
		return clienteRepositorio.save(cliente);
	}
	
	@Transactional
	public void modificarCliente(String id, String nombre, String direccion, String email, String telefono, String clave) throws Exception {
		Optional<Cliente> respuesta = clienteRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Cliente cliente = respuesta.get();
			cliente.setId(id);
			cliente.setNombre(nombre);
			cliente.setClave(clave);
			cliente.setDireccion(direccion);
			cliente.setTelefono(telefono);
			cliente.setEmail(email);
			clienteRepositorio.save(cliente);
		} else {
			throw new Exception("error en el modificar-cliente");
		}
	}
	
	@Transactional
	public List<Cliente> listarTodos() {
		return clienteRepositorio.findAll();
	}
	
}