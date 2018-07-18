/**
 * 
 */
package com.app.mongo.repo;

import com.app.mongo.model.Customer;

/**
 * @author Sandeep Reddy Battula
 *
 */
public interface SpringMongoRepo {

	public Customer findByLastName(String name);
}
