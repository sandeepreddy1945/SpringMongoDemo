package com.app.mongo.service;

import com.app.mongo.model.Customer;

/**
 * 
 * @author Sandeep Reddy Battula
 *
 */

public interface SpringMongoService {

	public Customer findByLastName(String name);
}
