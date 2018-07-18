package com.app.mongo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import com.app.mongo.model.Customer;

/**
 * 
 * @author Sandeep Reddy Battula
 *
 */
@Repository
public class SpringMongoRepoImpl implements SpringMongoRepo {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Customer findByLastName(String name) {
		return mongoTemplate.findAll(Customer.class).get(0);
	}

}
