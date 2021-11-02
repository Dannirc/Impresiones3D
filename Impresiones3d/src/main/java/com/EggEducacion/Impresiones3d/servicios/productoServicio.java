package com.EggEducacion.Impresiones3d.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EggEducacion.Impresiones3d.entidades.Archivo;
import com.EggEducacion.Impresiones3d.entidades.Categoria;
import com.EggEducacion.Impresiones3d.entidades.Producto;
import com.EggEducacion.Impresiones3d.repositorios.productoRepositorio;

@Service
public class productoServicio {
	@Autowired
	private productoRepositorio productoRepositorio;
	
	@Transactional
	public Producto crearProducto(String id,Archivo archivo, Categoria categoria) throws Exception {
		Producto producto = new Producto();
		producto.setId(id);
		producto.setNombre(archivo);
		return productoRepositorio.save(producto);
	}
	
}
