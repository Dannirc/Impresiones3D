package com.EggEducacion.Impresiones3d.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.EggEducacion.Impresiones3d.entidades.Archivo;
import com.EggEducacion.Impresiones3d.entidades.Categoria;
import com.EggEducacion.Impresiones3d.servicios.ArchivoServicio;
import com.EggEducacion.Impresiones3d.servicios.categoriaServicio;
import com.EggEducacion.Impresiones3d.servicios.productoServicio;

@Controller
@RequestMapping("/producto")
public class ProductoControlador {

	@Autowired
	private productoServicio productoService;
	
	@Autowired
	private categoriaServicio categoriaService;
	
	@Autowired
	private ArchivoServicio archivoService;

	@GetMapping("/cargar-pedido")
	public ModelAndView crearproducto() {		
		return new ModelAndView("/producto/cargarPedido.html");
	}
	
	/*@GetMapping("/modificar-producto")
	public String modificarproducto(ModelMap modelo, @RequestParam("Id") String Id) {
		try {
		Producto producto= productoService.buscarPorId(Id);
		modelo.addAttribute("producto", producto);
		return ("producto/modificar-producto");
		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "producto/modificar-producto";
		}
	}*/
	
	/* esto deberia en controlador usuario o controlador pedido */
	@PostMapping("/cargar-pedido")
	public String guardar(ModelMap modelo,MultipartFile archivo,@RequestParam Integer porcentajeDeRelleno,@RequestParam Integer velocidadDelImpresion,
			@RequestParam Float diametroDeBoquita,@RequestParam String material,@RequestParam Float alturaDeCapa,@RequestParam Boolean soporte) {
		try {
			Categoria categoria=categoriaService.crearCategoria(material, porcentajeDeRelleno, velocidadDelImpresion, diametroDeBoquita, material, alturaDeCapa, soporte);
			Archivo Archivo=archivoService.guardar(archivo);
			productoService.crearProducto(Archivo, categoria);
			modelo.put("exito", "registro exitoso");
			return "producto/cargarPedido";
		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "producto/cargarPedido";
		}
	}
	
	@GetMapping("/cargar-producto")
	public String Cotizador() {		
		return ("producto/cargarproducto");
	}
	
	
	


}