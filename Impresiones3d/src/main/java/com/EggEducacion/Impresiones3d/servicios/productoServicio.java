package com.EggEducacion.Impresiones3d.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.EggEducacion.Impresiones3d.entidades.Archivo;
import com.EggEducacion.Impresiones3d.entidades.Categoria;
import com.EggEducacion.Impresiones3d.entidades.Producto;
import com.EggEducacion.Impresiones3d.repositorios.ProductoRepositorio;


@Service
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio ProductoRepositorio;
	
	@Autowired
	private ArchivoServicio archivoServicio;
	
	@Transactional
	public Producto crearProducto(MultipartFile file,String id, Categoria categoria) throws Exception {
		Producto producto = new Producto();
		producto.setId(id);
		producto.setCategoria(categoria);
		Archivo archivo = archivoServicio.guardar(file);
		producto.setArchivo(archivo);
		return ProductoRepositorio.save(producto);
	}
	
	@Transactional
	public void modificarProducto(MultipartFile file,String id, Categoria categoria) throws Exception {
		Optional<Producto> respuesta = ProductoRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Producto producto = respuesta.get();
			producto.setId(id);
			producto.setCategoria(categoria);
			
			String idArchivo=null;
			if(producto.getArchivo() != null) {
				idArchivo=producto.getArchivo().getId();
			}
			Archivo archivo = archivoServicio.actualizar(idArchivo,file);
			producto.setArchivo(archivo);
			ProductoRepositorio.save(producto);
		} else {
			throw new Exception("error en el modificar-producto");
		}
	}
	
	@Transactional
	public List<Producto> listarTodos() {
		return ProductoRepositorio.findAll();
	}
	
}