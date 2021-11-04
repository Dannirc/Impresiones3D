package com.EggEducacion.Impresiones3d.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
			@RequestParam String email, @RequestParam String clave, @RequestParam String rol, @RequestParam String telefono) {

		try {
			usuarioService.crearUsuario(rol, nombre, direccion, email, telefono, clave);
			modelo.put("exito", "registro exitoso");
			return "registrar";
		} catch (Exception e) {
			modelo.put("error", e.getMessage());
			return "registrar";
		}
	}

}