package com.EggEducacion.Impresiones3d.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cliente")
public class ClienteControlador {

	@GetMapping("/registrar")
	public String registrar() {		
		return ("cliente/registrar");
	}
	
	@GetMapping("/cargar-pedido")
	public String Cotizador() {		
		return ("cliente/cargarPedido");
	}
}
