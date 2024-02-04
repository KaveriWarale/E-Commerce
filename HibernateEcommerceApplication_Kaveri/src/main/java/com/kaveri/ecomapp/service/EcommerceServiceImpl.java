package com.kaveri.ecomapp.service;

import java.util.List;

import com.kaveri.ecomapp.dao.EcommerceDao;
import com.kaveri.ecomapp.dao.EcommerceDaoImpl;
import com.kaveri.ecomapp.model.Category;
import com.kaveri.ecomapp.model.Customer;
import com.kaveri.ecomapp.model.Product;

public class EcommerceServiceImpl implements EcommerceService {

	EcommerceDao ecommerceDaoImpl = new EcommerceDaoImpl();

	@Override
	public boolean saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.saveCustomer(customer);
	}

	@Override
	public Customer signIn(String customerEmail, String customerPassword) {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.signIn(customerEmail, customerPassword);
	}

	@Override
	public List<Customer> showAllCustomer() {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.showAllCustomer();
	}

	@Override
	public Customer findById(int customerID) {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.findById(customerID);
	}

	@Override
	public void updateData(int customerID, Customer customer) {
		// TODO Auto-generated method stub
		ecommerceDaoImpl.updateData(customerID, customer);

	}

	@Override
	public void deleteData(int customerID) {
		// TODO Auto-generated method stub
		ecommerceDaoImpl.deleteData(customerID);
	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub
		ecommerceDaoImpl.deleteAllData();
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		ecommerceDaoImpl.saveCategory(category);
	}

	@Override
	public List<Category> allCategory() {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.allCategory();
	}

	@Override
	public void saveProducts(Product product) {
		// TODO Auto-generated method stub
		ecommerceDaoImpl.saveProducts(product);

	}

	@Override
	public Category findCategoryByID(int categoryID) {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.findCategoryByID(categoryID);
	}

	@Override
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.allProducts();
	}

	@Override
	public Product findProductByID(int productID) {
		// TODO Auto-generated method stub
		return ecommerceDaoImpl.findProductByID(productID);
	}

}
