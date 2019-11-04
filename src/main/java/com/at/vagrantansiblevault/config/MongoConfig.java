package com.at.vagrantansiblevault.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

@Configuration
public class MongoConfig {

	@Value("${mongodb.host}")
	private String host;

	@Value("${mongodb.port}")
	private Integer port;

	@Value("${mongodb.database}")
	private String database;

	@Value("${vault_mongodb_user}")
	private String secret_user;

	@Value("${vault_mongodb_password}")
	private String secret_password;

//	@Autowired
//	private VaultTemplate template;

	@Bean
	public MongoDbFactory mongoDbFactory() throws Exception {
		// VaultResponseSupport<KeyValue> user = template.read(secret_user,
		// KeyValue.class);
		// VaultResponseSupport<KeyValue> password = template.read(secret_password,
		// KeyValue.class);
		MongoCredential credential = MongoCredential.createCredential("user", database, "password".toCharArray());
		ServerAddress serverAddress = new ServerAddress(host, port);
		MongoClientOptions options = MongoClientOptions.builder().build();

		MongoClient mongoClient = new MongoClient(serverAddress, credential, options);

		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoClient, database);

		return simpleMongoDbFactory;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoDbFactory());
	}
}