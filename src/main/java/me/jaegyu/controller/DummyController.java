package me.jaegyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api(value = "/v1/dummy", tags = { "Dummy" }, description = "더미 입니다.")
@RestController
@RequestMapping(value = "/v1/dummy")
public class DummyController {
	
	@ApiOperation(value = "더이", authorizations = { @Authorization(value = "basicAuth") })
	@GetMapping("/{id}")
	public String dummy(@PathVariable("id") String id) {
		return "{id :" + id + "}";
	}
	
}
