package com.bolton.CORA.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.CORA.Domains.Customer;
import com.bolton.CORA.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired	
	CustomerRepository customerRepository;
	
	// Adding customer ----------------------------	
	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}//----------------------------------------------
	
	//Login check-----------------------------------------------------------------------------
	public String validateRegisteredUser(String emails, String passw) {
		String name = null;
		for (Customer customer : customerRepository.findAll()) {
			if (customer.getEmail().equals(emails) && customer.getPassword().equals(passw)) {
				name = customer.getName();
			}
		}
		return name;
	}//-----------------------------------------------------------------------------------------
}