package com.EggEducacion.Impresiones3d.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.EggEducacion.Impresiones3d.entidades.Categoria;
import com.EggEducacion.Impresiones3d.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServicio {
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Transactional
	public Categoria crearCategoria(String id, String nombre, Integer porcentajeDeRelleno,
			Integer velocidadDelImpresion, Float diametroDeBoquita, String material, Float alturaDeCapa,
			Boolean soporte) throws Exception {
		Categoria Categoria = new Categoria();
		Categoria.setId(id);
		Categoria.setNombre(nombre);
		Categoria.setAlturaDeCapa(alturaDeCapa);
		Categoria.setDiametroDeBoquita(diametroDeBoquita);
		Categoria.setPorcentajeDeRelleno(porcentajeDeRelleno);
		Categoria.setSoporte(soporte);
		Categoria.setVelocidadDelImpresion(velocidadDelImpresion);
		Categoria.setMaterial(material);
		return categoriaRepositorio.save(Categoria);
	}

	@Transactional
	public void modificarCategoria(String id, String nombre, Integer porcentajeDeRelleno, Integer velocidadDelImpresion,
			Float diametroDeBoquita, String material, Float alturaDeCapa, Boolean soporte) throws Exception {
		Optional<Categoria> respuesta = categoriaRepositorio.findById(id);
		if (respuesta.isPresent()) {
			Categoria Categoria = respuesta.get();
			Categoria.setId(id);
			Categoria.setNombre(nombre);
			Categoria.setAlturaDeCapa(alturaDeCapa);
			Categoria.setDiametroDeBoquita(diametroDeBoquita);
			Categoria.setPorcentajeDeRelleno(porcentajeDeRelleno);
			Categoria.setSoporte(soporte);
			Categoria.setVelocidadDelImpresion(velocidadDelImpresion);
			Categoria.setMaterial(material);
			categoriaRepositorio.save(Categoria);
		} else {
			throw new Exception("error en el modificar-Categoria");
		}
	}

	@Transactional
	public List<Categoria> listarTodos() {
		return categoriaRepositorio.findAll();
	}

}