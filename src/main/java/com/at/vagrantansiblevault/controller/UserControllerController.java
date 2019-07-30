package com.at.vagrantansiblevault.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.at.vagrantansiblevault.model.User;
import com.at.vagrantansiblevault.repository.UserRepository;

@RestController
public class UserControllerController {

	@Autowired
	private UserRepository repository;

	@GetMapping
	public ResponseEntity<List<User>> test() {
		return new ResponseEntity<List<User>>(repository.findAll(), HttpStatus.OK);
	}
}
