package com.kaveri.ecomapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private int productId;
	private String productName;
	private String productDescription;

	@Lob
	@Column(columnDefinition = "mediumblob")
	private String productPhoto;
	
	private String productColor;
	private int productPrice;
	private int productDiscount;
	private int productQuantity;

	@ManyToOne
	private Category category;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, String productDescription, String productPhoto, String productColor,
			int productPrice, int productDiscount, int productQuantity, Category category) {
		super();
		this.productName = productName;
		this.productDescription = productDescription;
		this.productPhoto = productPhoto;
		this.productColor = productColor;
		this.productPrice = productPrice;
		this.productDiscount = productDiscount;
		this.productQuantity = productQuantity;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductPhoto() {
		return productPhoto;
	}

	public void setProductPhoto(String productPhoto) {
		this.productPhoto = productPhoto;
	}

	public String getProductColor() {
		return productColor;
	}

	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(int productDiscount) {
		this.productDiscount = productDiscount;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	// Final Price After Discount
	public int getFinalPriceWithDiscount() {

		double discountPrice = ((this.getProductDiscount() / 100.0)) * (this.getProductPrice());
		int d = (int) discountPrice;
		return this.getProductPrice() - d;

	}

	// Product Title with 3 words
	public String getProductTitle() {
		String pDes[] = this.getProductName().split(" ");
		String strProductTitle = "";
		int j = 0;
		for (int i = 0; i <= pDes.length; i++) {
			j++;
			strProductTitle += pDes[i] + " ";
			if (j == 3) {
				break;
			}
		}
		return strProductTitle;
	}

	//Product Description with 8 words
	public String getProductDes() {
		String pDes[] = this.getProductDescription().split(" ");
		String strProductDes = "";
		int j = 0;
		for (int i = 0; i <= pDes.length; i++) {
			j++;
			strProductDes += pDes[i] + " ";
			if (j == 8) {
				break;
			}
		}
		return strProductDes;
	}
}
