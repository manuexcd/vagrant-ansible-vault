package com.at.vagrantansiblevault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.at.vagrantansiblevault.repository")
public class VagrantAnsibleVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(VagrantAnsibleVaultApplication.class, args);
	}

}
