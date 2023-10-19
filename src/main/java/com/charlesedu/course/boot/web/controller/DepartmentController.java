package com.charlesedu.course.boot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charlesedu.course.boot.domain.Department;
import com.charlesedu.course.boot.service.DepartmentService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired
	private DepartmentService service;

	@GetMapping("/register")
	public String register(Department department) {
		return "department/register";
	}

	@PostMapping("/save")
	public String save(@Valid Department department, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "department/register";
		}

		service.save(department);

		attr.addFlashAttribute("success", "Departamento inserido com sucesso.");

		return "redirect:/departments/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("departments", service.findAll());

		return "department/list";
	}

	@GetMapping("/update/{id}")
	public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("department", service.findById(id));

		return "department/register";
	}

	@PostMapping("/update")
	public String update(@Valid Department department, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "department/register";
		}

		service.update(department);

		attr.addFlashAttribute("success", "Departamento editado com sucesso.");

		return "redirect:/departments/register";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		if (service.departmentHaveRoles(id)) {
			model.addAttribute("fail", "Departamento não removido. Possui cargo(s) vinculados.");
		} else {
			service.delete(id);

			model.addAttribute("success", "Departamento removido com sucesso.");
		}

		return list(model);
	}

}
