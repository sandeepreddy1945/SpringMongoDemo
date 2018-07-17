/**
 * 
 */
package com.app.mongo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.mongo.model.Customer;
import com.app.mongo.repo.CustomerRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Sandeep
 *
 */
@Api
@RestController
public class SpringMongoRestController {

    @Autowired
    private CustomerRepository customerRepository;

    @ApiOperation(value = "Add Customer")
    @RequestMapping(path = "api/customer/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        customer = customerRepository.save(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.ACCEPTED);

    }

    @ApiOperation(value = "List All Customers")
    @RequestMapping(path = "api/customer/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> listAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @ApiOperation(value = "List All Customers Queried by Last Name")
    @RequestMapping(path = "api/customer/list/:lastName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Customer>> listAllCustomersByastName(@RequestParam String lastName) {
        List<Customer> customers = customerRepository.findByLastName(lastName);
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
}
