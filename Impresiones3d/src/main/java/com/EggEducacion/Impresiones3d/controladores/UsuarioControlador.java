package com.EggEducacion.Impresiones3d.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.EggEducacion.Impresiones3d.entidades.Usuario;
import com.EggEducacion.Impresiones3d.servicios.UsuarioServicio;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioService;

	@GetMapping("/registro")
	public String formulario() {
		return "registrar";
	}

	@PostMapping("/registro")
	public String guardar(ModelMap modelo, @RequestParam String nombre, @RequestParam String direccion,
			@RequestParam String email, @RequestParam String clave, @RequestParam String rol,
			@RequestParam String telefono) {

		try {
			usuarioService.crearUsuario(rol, nombre, direccion, email, telefono, clave);
			modelo.put("exito", "registro exitoso");
			return "registrar";
		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "registrar";
		}
	}

	@GetMapping("/listar-usuarios")
	public String listar(ModelMap modelo) {

		List<Usuario> listarUsuarios = usuarioService.listarTodos();
		modelo.addAttribute("usuarios", listarUsuarios);

		return "usuario/listaUsuarios";
	}

	@GetMapping("/eliminar-usuario")
	public String eliminar(String id) {

		usuarioService.eliminarUsuario(id);

		return "usuario/listaUsuarios";
	}

	@GetMapping("/lista-pedidos")
	public String listaPedidos() {
		return "usuario/listaPedidos2";
	}

	@GetMapping("/cargar-pedido")
	public String Cotizador() {
		return ("usuario/cargarPedido");
	}

	/* EDITAR PARA USUARIO!
	
	@GetMapping("/crear-autor")
	public ModelAndView crearAutor() {
		return new ModelAndView("/autor/crear_autor.html");
	}

	@GetMapping("/modificar-autor")
	public String modificarAutor(ModelMap modelo, @RequestParam("Id") String Id) {
		Autor autor = autorServicio.consultaAutor(Id);
		modelo.addAttribute("autor", autor);

		return ("autor/modificar-autor");
	}

	@PostMapping("/guardar-autor")
	public String guardarAutor(ModelMap modelo, @RequestParam String nombre, @RequestParam String autorId)
			throws ErrorServicio {
		if (autorId == null) {
			autorServicio.crearAutor(nombre);
			modelo.put("exito!", "Registro Exitoso!");
		} else {
			autorServicio.modificarAutor(autorId, nombre);
			modelo.put("exito!", "Registro Exitoso!");
		}

		return "redirect:/autor/listar-autores/";
	} */

}