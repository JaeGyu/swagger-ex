package me.jaegyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {

	@GetMapping("/dummy")
	public String sw() {
		return "swagger";
	}

	@GetMapping("/member")
	public String mem() {
		return "swagger_member";
	}

}
