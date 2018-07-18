package com.app.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mongo.model.Customer;
import com.app.mongo.repo.SpringMongoRepo;

/**
 * 
 * @author Sandeep Reddy Battula
 *
 */
@Service
public class SpringMongoServiceImpl implements SpringMongoService {

	@Autowired
	private SpringMongoRepo repo;

	@Override
	public Customer findByLastName(String name) {
		return repo.findByLastName(name);
	}

}
