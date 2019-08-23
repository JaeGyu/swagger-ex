package me.jaegyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

	@GetMapping("/dummy")
	public String sw(Model model) {
		model.addAttribute("url", "http://localhost:8040/v2/api-docs?group=dummy");
		return "swagger";
	}

	@GetMapping("/member")
	public String mem(Model model) {
		model.addAttribute("url", "http://localhost:8040/v2/api-docs?group=member");
		return "swagger";
	}

}
