package com.bolton.CORA.Domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	@Column(name = "Barcode")
	private String barcode;

	@Column(name = "Product_name")
	private String productName;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Description")
	private String description;

	@Column(name = "Price")
	private int price;

	@Column(name = "image")
	private String image;

	public Product() {

	}

	public Product(String productname, int quantity, String description, int price, String image) {
		super();
		this.productName = productname;
		this.quantity = quantity;
		this.description = description;
		this.price = price;
		this.image = image;
	}

	@Override
	public String toString() {
		return "Product [barcode=" + barcode + ", productName=" + productName + ", quantity=" + quantity
				+ ", description=" + description + ", price=" + price + ", image=" + image + "]";
	}

	public String getProductName() {
		return productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public String getBarcode() {
		return barcode;
	}
}