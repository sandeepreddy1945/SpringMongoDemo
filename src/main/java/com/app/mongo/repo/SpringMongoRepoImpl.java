package com.app.mongo.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
		// check for the items with last name as 'reddy'
		Query query = new Query();
		query.addCriteria(Criteria.where("lastName").in("reddy"));

		return mongoTemplate.find(query, Customer.class).get(0);
	}

}
