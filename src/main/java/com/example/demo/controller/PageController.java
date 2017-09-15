package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

	@RequestMapping("/hello")
	public String index() {
		return "hello";
	}

	@RequestMapping("/perkalian")
	public String perkalian(@RequestParam(value = "a", required = false) Integer a,
			@RequestParam(value = "b", required = false) Integer b, Model model) {
		if (a != null && b != null) {
			int c = a * b;
			String hasil = a + " x " + b + " = " + c;	
			model.addAttribute("hasil", hasil);
			
		} else if (a == null && b != null) {
			a = 0;
			String hasil = a + " x " + b + " = " + 0;
			model.addAttribute("hasil", hasil);
		} else if (a != null && b == null) {
			b = 0;			
			String hasil = a + " x " + b + " = " + 0;
			model.addAttribute("hasil", hasil);
		} else {
			String hasil = 0 + " x " + 0 + " = " + 0;
			model.addAttribute("hasil", hasil);
		}
		
		return "perkalian";
	}

//	@RequestMapping("/greeting")
//	public String greeting(@RequestParam(value = "a", required = false, defaultValue = "dunia") String name,
//			Model model) {
//		model.addAttribute("name", name);
//		return "greeting";
//	}

	@RequestMapping(value = { "/greeting", "greeting/{name}" })
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if (name.isPresent()) {
			model.addAttribute("name", name.get());
		} else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
}
