package com.charlesedu.course.boot.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.charlesedu.course.boot.domain.Department;
import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.service.DepartmentService;
import com.charlesedu.course.boot.service.RoleService;
import com.charlesedu.course.boot.util.PaginationUtil;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/register")
	public String register(Role role) {
		return "role/register";
	}

	@PostMapping("/save")
	public String save(@Valid Role role, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "role/register";
		}

		roleService.save(role);

		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");

		return "redirect:/roles/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("sort") Optional<String> sort, @RequestParam("property") Optional<String> property,
			@RequestParam("size") Optional<Integer> size) {
		int currentPage = page.orElse(1);
		int currentSize = size.orElse(5);

		String sortCriteria = sort.orElse("asc");
		String sortProperty = property.orElse("name");

		PaginationUtil<Role> rolePage = roleService.paginationSearch(currentPage, sortCriteria, sortProperty,
				currentSize);

		model.addAttribute("rolePage", rolePage);

		return "role/list";
	}

	@GetMapping("/update/{id}")
	public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("role", roleService.findById(id));

		return "role/register";
	}

	@PostMapping("/update")
	public String update(@Valid Role role, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "role/register";
		}

		roleService.update(role);

		attr.addFlashAttribute("success", "Cargo editado com sucesso.");

		return "redirect:/roles/register";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
		if (roleService.roleHaveEmployees(id)) {
			attr.addFlashAttribute("fail", "Cargo não removido. Possui funcionario(s) vinculados.");
		} else {
			roleService.delete(id);

			attr.addFlashAttribute("success", "Cargo removido com sucesso.");
		}

		return "redirect:/roles/list";
	}

	@ModelAttribute("departments")
	public List<Department> departmentList() {
		return departmentService.findAll();
	}
}
