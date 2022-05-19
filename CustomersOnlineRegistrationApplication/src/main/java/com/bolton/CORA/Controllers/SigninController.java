package com.bolton.CORA.Controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.CORA.Domains.Customer;
import com.bolton.CORA.Repository.CustomerRepository;
import com.bolton.CORA.Service.CustomerService;

@Controller
@SessionAttributes("customerName")
public class SigninController {
	@Autowired
	CustomerRepository customerReposatory;                                         
	@Autowired
	CustomerService customerService;
	
	// Sign in page Mapping --------	
	@RequestMapping("/signin")
	public String signin() {
		return ("signin");
	}//-------------------------------
		
    // Sign in functionality -------------------------------------------------------------------------------------------	
	@PostMapping("/add")
	public String addCustomer(@RequestParam String username, String usersurname, String useraddress, long userphone,
			String useremail, String userpass) throws SQLException {
		Customer customer = new Customer(username, usersurname, useraddress, userphone, useremail, userpass);
		try {
			customerService.addCustomer(customer);			
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			return "emailError";
		}
	}//-------------------------------------------------------------------------------------------------------------------
}