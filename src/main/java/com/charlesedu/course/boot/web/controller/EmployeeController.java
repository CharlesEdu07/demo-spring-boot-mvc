package com.charlesedu.course.boot.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.charlesedu.course.boot.domain.Employee;
import com.charlesedu.course.boot.domain.Role;
import com.charlesedu.course.boot.domain.enums.FederativeUnit;
import com.charlesedu.course.boot.service.EmployeeService;
import com.charlesedu.course.boot.service.RoleService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@GetMapping("/register")
	public String register(Employee employee) {
		return "/employee/register";
	}

	@PostMapping("/save")
	public String save(@Valid Employee employee, BindingResult result, RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/employee/register";
		}

		employeeService.save(employee);

		attr.addFlashAttribute("success", "Funcionário inserido com sucesso.");

		return "redirect:/employees/register";
	}

	@GetMapping("/list")
	public String list(ModelMap model) {
		model.addAttribute("employees", employeeService.findAll());

		return "/employee/list";
	}

	@GetMapping("/search/name")
	public String getByName(@RequestParam("name") String name, ModelMap model) {
		model.addAttribute("employees", employeeService.findByName(name));

		return "/employee/list";
	}

	@GetMapping("/search/role")
	public String getByRole(@RequestParam("id") Long id, ModelMap model) {
		model.addAttribute("employees", employeeService.findByRole(id));

		return "/employee/list";
	}

	@GetMapping("/search/date")
	public String getByDate(
			@RequestParam(name = "admission", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate admission,
			@RequestParam(name = "exit", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exit,
			ModelMap model) {
		model.addAttribute("employees", employeeService.findByDate(admission, exit));

		return "/employee/list";
	}

	@GetMapping("/update/{id}")
	public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("employee", employeeService.findById(id));

		return "employee/register";
	}

	@PostMapping("/update")
	public String update(@Valid Employee employee, BindingResult result ,RedirectAttributes attr) {
		if (result.hasErrors()) {
			return "/employee/register";
		}

		employeeService.update(employee);

		attr.addFlashAttribute("success", "Funcionário editado com sucesso.");

		return "redirect:/employees/register";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id, ModelMap model) {
		employeeService.delete(id);

		model.addAttribute("success", "Funcionário removido com sucesso.");

		return list(model);
	}

	@ModelAttribute("roles")
	public List<Role> getRoles() {
		return roleService.findAll();
	}

	@ModelAttribute("federativeUnits")
	public FederativeUnit[] getFederativeUnits() {
		return FederativeUnit.values();
	}

}
