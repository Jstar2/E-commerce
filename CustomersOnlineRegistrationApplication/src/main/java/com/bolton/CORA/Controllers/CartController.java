package com.bolton.CORA.Controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.CORA.Domains.Customer;
import com.bolton.CORA.Domains.Product;
import com.bolton.CORA.Domains.Receipt;
import com.bolton.CORA.Repository.ReciptRepository;
import com.bolton.CORA.Service.ProductService;

@SessionAttributes("customerName")
@Controller
public class CartController {
	@Autowired
	ProductService productService;
	@Autowired
	ReciptRepository reciptRepository;

	Customer customer;

	List<Product> productsList = new ArrayList<>();

	// cart page Mapping--------------
	@RequestMapping("/cart")
	public String shopCart(ModelMap model, HttpSession session) {
		model.put("productCart", productsList);
		LoginController.geTsession(model, session);
		return "cart";
	}
	// -------------------------------

	// Adding to products to cart------------------------------------------------
	@RequestMapping(value = {"/selectProduct"})
	public String selectProduct(@RequestParam String barcode, ModelMap model, HttpSession session) {
		Product product = productService.findByBarcode(barcode);
		productsList.add(product);
		model.put("productCart", productsList);
		model.addAttribute("total", sumProducts());
		LoginController.geTsession(model, session);
		return "cart";
	}// -------------------------------------------------------------------------

	// Removing products from cart------------------------------------------------
	@RequestMapping("/removeProduct")
	public String remove(@RequestParam String productName, ModelMap model, HttpSession session) {
		productsList.removeIf(e -> e.getProductName().equals(productName));
		model.put("productCart", productsList);
		model.addAttribute("total", sumProducts());
		LoginController.geTsession(model, session);
		return "cart";
	}// --------------------------------------------------------------------------

	// sum of productList------------------------------
	public int sumProducts() {
		int sum = 0;
		for (int i = 0; i < productsList.size(); i++) {
			sum += productsList.get(i).getPrice();
		}
		return sum;
	}// -----------------------------------------------

	// payment
	// method------------------------------------------------------------------------
	@RequestMapping("/pay")
	public String payCheckOut(ModelMap model, HttpSession session) throws SQLException {

		if (session == null) {
			model.put("paidOrNot", "Please log-in first before you can buy any product");
			LoginController.geTsession(model, session);
			return "cart";
		} else {
			String e = LoginController.getlogEmail();
			String date = "2022-01-22";
			int total = sumProducts();

			if (total != 0) {
				System.out.println(total + " " + e + "" + date);

				Receipt receipt = new Receipt(total, date, e);
				try {
					LoginController.geTsession(model, session);
					reciptRepository.save(receipt);

					model.put("namE", session);					
					model.put("datE", date);
					model.put("emaiL", e);
					model.put("paiD", total);				

					LoginController.geTsession(model, session);
					productsList.clear();
					return "reciept";

				} catch (Exception ex) {
					ex.printStackTrace();
					model.put("paidOrNot", "Please log-in ");
					LoginController.geTsession(model, session);
					return "cart";
				}

			} else {
				model.put("paidOrNot", "Please add at least one product");
				return "cart";
			}
		} // ----------------------------------------------------------------------------------------

	}
}