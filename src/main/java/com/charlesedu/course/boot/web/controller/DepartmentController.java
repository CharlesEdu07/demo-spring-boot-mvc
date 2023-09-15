package com.charlesedu.course.boot.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartmentController {
	
	@GetMapping("/cadastrar")
	public String signUp() {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String list() {
		return "/departamento/lista";
	}
	
}
