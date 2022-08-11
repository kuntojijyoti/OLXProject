package com.zensar.olx.user.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olx.user.bean.OlxUser;
import com.zensar.olx.user.service.OlxUserService;

@RestController
public class OlxUserController {
	@Autowired
	OlxUserService service;
	@PostMapping("/user")
	public OlxUser registeruser(@RequestBody OlxUser olxuser)
	{
		return this.service.addOlxUser(olxuser);
	}
	@GetMapping("/findUserById/{uid}")
	
	public OlxUser findOlxUserById(@PathVariable(name="uid")int id) {
		return this.service.findOlxUserById(id);
		
		
	}
	@GetMapping("/findUserByName/{userName}")
	public OlxUser findOlxUserByName(@PathVariable(name="userName")String name) {
		return this.service.findOlxUserByName(name);
	}
	}

