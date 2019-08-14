package me.jaegyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/member-profiles")
public class MembersProfilesController {

	@GetMapping("/{id}")
	public String memberProfile(@PathVariable("id") String id) {
		return "{id :" + id + "}";
	}

}
