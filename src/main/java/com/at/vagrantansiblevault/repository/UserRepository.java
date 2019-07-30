package com.at.vagrantansiblevault.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.at.vagrantansiblevault.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}