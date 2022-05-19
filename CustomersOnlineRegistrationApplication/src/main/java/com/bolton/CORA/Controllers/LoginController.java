package com.bolton.CORA.Controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.CORA.Repository.CustomerRepository;
import com.bolton.CORA.Service.CustomerService;

@Controller
@SessionAttributes("customerName")
public class LoginController {
	@Autowired
	CustomerService customerService;
	@Autowired
	CustomerRepository customerRepoisatory;	
	
	static String email = null;	
	private static String customerName;

	// Log in page Mapping -------------------------
	@RequestMapping("/login")
	public String login(ModelMap model, HttpSession session) {
		geTsession(model, session);
		return "login";
	}// ---------------------------------------------

	// log in
	// Functionality----------------------------------------------------------------------
	@PostMapping("/log")
	public String customerLogin(@RequestParam String emails, String passw, ModelMap model, HttpSession session) {
		email = emails;
		
		customerName = customerService.validateRegisteredUser(emails, passw);		
		
		if (customerName == null) {
			model.put("errorMessage", "Not a valid user");
			geTsession(model, session);
			return "login-error";
		} else {
			model.put("userName", customerName);
			model.addAttribute("logCus", customerName);
			session.setAttribute(customerName, customerName);
			geTsession(model, session);
			return "index";
		}
	} // ------------------------------------------------------------------------------------

	// Log out functionality----------------------------------------------
	@RequestMapping("/logout")
	public String customerLogout(ModelMap model, HttpSession session){	
		customerName = null;				
		geTsession(model,session);
		return "login";
	}// -------------------------------------------------------------------

	// display session-----------------------------------------------------
	public static void geTsession(ModelMap model, HttpSession session) {
		if (session != null) {
			model.put("logCustomer", customerName);
		} else {
			model.put("logCustomer", null);
		}//----------------------------------------------------------------
	}	
	
	public static String getlogEmail() {		
		return email;
	}
}