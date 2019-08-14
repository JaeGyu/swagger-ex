package me.jaegyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;

@Api(value = "/v1/member-profiles", tags = { "MemberProfile" }, description = "ȸ�� ������ ����")
@RestController
@RequestMapping(value = "/v1/member-profiles")
public class MembersProfilesController {

	@ApiOperation(value = "������ ����", authorizations = { @Authorization(value = "basicAuth") })
	@GetMapping("/{id}")
	public String memberProfile(@PathVariable("id") String id) {
		return "{id :" + id + "}";
	}
}
