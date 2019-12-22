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

import com.javahelps.restservice.entity.User;

import com.javahelps.restservice.repository.UserRepository;

import javassist.tools.web.BadHttpRequest;

@RestController
@RequestMapping(path = "/foods")
public class UserController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public Iterable<User> findAll() {
		return repository.findAll();
	}

	@GetMapping(path = "/{yemek}")
	public User find(@PathVariable("yemek") String yemek) {
		return repository.findOne(yemek);
	}

	@PostMapping(consumes = "application/json")
	public User create(@RequestBody User user) {
		return repository.save(user);
	}

	@DeleteMapping(path = "/{yemek}")
	public void delete(@PathVariable("yemek") String yemek) {
		repository.delete(yemek);
	}

	@PutMapping(path = "/{yemek}")
	public User update(@PathVariable("yemek") String yemek, @RequestBody User user) throws BadHttpRequest {
		if (repository.exists(yemek)) {
			user.setYemek(yemek);
			return repository.save(user);
		} else {
			throw new BadHttpRequest();
		}
	}

	
}
