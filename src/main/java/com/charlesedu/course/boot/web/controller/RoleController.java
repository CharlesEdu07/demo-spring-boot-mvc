package com.charlesedu.course.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charlesedu.course.boot.domain.Department;
import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.service.DepartmentService;
import com.charlesedu.course.boot.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/register")
	public String register(Role role) {
		return "/role/register";
	}

	@GetMapping("/list")
	public String list() {
		return "/role/list";
	}
	
	@PostMapping("/save")
	public String save(Role role, RedirectAttributes attr) {
		roleService.save(role);
		
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");

		return "redirect:/roles/register";
	}
	
	@ModelAttribute("departments")
	public List<Department> departmentList() {
		return departmentService.findAll();
	}

}
