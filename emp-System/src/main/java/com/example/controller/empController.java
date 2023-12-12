package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.emp;
import com.example.service.empSer;

import jakarta.servlet.http.HttpSession;

@Controller
public class empController {

	@Autowired
	private empSer service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<emp> emp = service.getEmp();
		m.addAttribute("emp",emp);
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmp() {
		return "AddEmp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute emp e,HttpSession session) {
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String empEdit(@PathVariable int id, Model m) {
		
		emp e =service.getEdit(id);
		m.addAttribute("emp", e);
		return "edit";
		
	}
	
	@PostMapping("/update")
	public String empUpdate(@ModelAttribute emp e) {
		service.addEmp(e);
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		service.deleteEmp(id);
		return "redirect:/";
		
	}
}
