package com.EggEducacion.Impresiones3d.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/", "/index"})
public class indexControlador {
	
	@GetMapping
	public String index() {		
		return ("index");
	}
}
