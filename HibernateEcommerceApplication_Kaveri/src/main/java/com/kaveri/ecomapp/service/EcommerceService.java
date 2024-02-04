package com.kaveri.ecomapp.service;

import java.util.List;

import com.kaveri.ecomapp.model.Category;
import com.kaveri.ecomapp.model.Customer;
import com.kaveri.ecomapp.model.Product;

public interface EcommerceService {

	public boolean saveCustomer(Customer customer);

	Customer signIn(String customerEmail, String customerPassword);

	List<Customer> showAllCustomer();

	public Customer findById(int customerID);

	public void updateData(int customerID, Customer customer);

	public void deleteData(int customerID);

	public void deleteAllData();

	public void saveCategory(Category category);

	List<Category> allCategory();

	public void saveProducts(Product product);
	
	public Category findCategoryByID(int categoryID);
	
	List<Product> allProducts();
	
	public Product findProductByID(int productID);

}
