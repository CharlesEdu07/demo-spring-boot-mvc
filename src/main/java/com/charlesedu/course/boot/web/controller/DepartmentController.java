package com.charlesedu.course.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.charlesedu.course.boot.domain.Department;
import com.charlesedu.course.boot.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@GetMapping("/register")
	public String register(Department department) {
		return "/department/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("departments", service.findAll());

		return "/department/list";
	}

	@PostMapping("/save")
	public String save(Department department) {
		service.save(department);

		return "redirect:/departments/register";
	}

	@GetMapping("/update/{id}")
	public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", service.findById(id));

		return "department/register";
	}

	@PostMapping("/update")
	public String update(Department department) {
		service.update(department);

		return "redirect:/departments/register";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		if (!service.departmentHaveRoles(id)) {
			service.delete(id);
		}

		return list(model);
	}

}
