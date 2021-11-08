package com.EggEducacion.Impresiones3d.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"/", "/index"})
public class IndexControlador {

	@GetMapping
	public String index() {		
		return ("index");
	}
  
	@GetMapping("/login")
	public String login(HttpSession session, Authentication usuario, ModelMap modelo, @RequestParam(required = false) String error) {
		try {
			if (usuario.getName() != null) {
				return "redirect:/";
			} else {
				
				if (error != null && !error.isEmpty()) {
					modelo.addAttribute("error", "La direcci�n de mail o la contrase�a que ingres� son incorrectas.");
				}
				return "login";
			}
			
		} catch (Exception e) {
			if (error != null && !error.isEmpty()) {
				modelo.addAttribute("error", "La direcci�n de mail o la contrase�a que ingres� son incorrectas.");
			}
			return "login";
		}
	}
	
	@GetMapping("/loginsuccess")
	public String loginresolver() {
				
		return "redirect:/";
	}
	
	@GetMapping("/prueba")
	public String prueba() {		
		return ("usuario/prueba");
	}

}