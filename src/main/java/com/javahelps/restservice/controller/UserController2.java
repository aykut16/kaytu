package com.javahelps.restservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javahelps.restservice.entity.User2;
import com.javahelps.restservice.repository.UserRepository2;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/users2")
public class UserController2 {

	@Autowired
	private UserRepository2 repository;

	@GetMapping
	public Iterable<User2> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{username}")
	public User2 find(@PathVariable("username") String username) {
		return repository.findOne(username);
	}

	@PostMapping(consumes = "application/json")
	public User2 create(@RequestBody User2 user2) {
		return repository.save(user2);
	}

	@DeleteMapping(path = "/{username}")
	public void delete(@PathVariable("username") String username) {
		repository.delete(username);
	}

	@PutMapping(path = "/{username}")
	public User2 update(@PathVariable("username") String username, @RequestBody User2 user2) throws BadHttpRequest {
		if (repository.exists(username)) {
			user2.setUsername(username);
			return repository.save(user2);
		} else {
			throw new BadHttpRequest();
		}
	}

	
}
