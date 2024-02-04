package com.kaveri.ecomapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.kaveri.ecomapp.model.Category;
import com.kaveri.ecomapp.model.Customer;
import com.kaveri.ecomapp.model.Product;

public class EcommerceDaoImpl implements EcommerceDao {

	public SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

	@Override
	public boolean saveCustomer(Customer customer) {
		boolean status = false;

		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Customer where customerEmail=:e");

		query.setParameter("e", customer.getCustomerEmail());
		Customer cmp = null;
		cmp = (Customer) query.uniqueResult();
		if (cmp == null) {
			Transaction transaction = session.beginTransaction();

			session.save(customer);

			transaction.commit();

			status = true;
		}
		return status;
	}

	@Override
	public Customer signIn(String customerEmail, String customerPassword) {

		/*
		 * boolean status = false; for (Customer customer : showAll()) if
		 * (customer.getCustomerEmail().equals(customerEmail) &&
		 * customer.getCustomerPassword().equals(customerPassword)) { status = true;
		 * break; } return status;
		 */
		
		Customer customer = null;
		Session session = sessionFactory.openSession();

		Query query = session.createQuery("from Customer where customerEmail=:e and customerPassword=:p");

		query.setParameter("e", customerEmail);
		query.setParameter("p", customerPassword);
		
		customer = (Customer) query.uniqueResult();
		return customer;

	}

	@Override
	public void saveCategory(Category category) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(category);
		transaction.commit();
		session.close();
	}

	@Override
	public List<Customer> showAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();

		Session session = sessionFactory.openSession();

		customers = session.createQuery("from Customer").list();

		return customers;
	}

	@Override
	public Customer findById(int customerID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateData(int customerID, Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteData(int customerID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllData() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> allCategory() {
		// TODO Auto-generated method stub
		// List<Category> categories = new ArrayList<Category>();

		Session session = sessionFactory.openSession();

		List<Category> categories = session.createQuery("from Category").list();

		return categories;
	}

	@Override
	public void saveProducts(Product product) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(product);
		transaction.commit();
		session.close();
	}

	@Override
	public Category findCategoryByID(int categoryID) {
		// TODO Auto-generated method stub
		Category category = null;

		Session session = sessionFactory.openSession();
		category = (Category) session.get(Category.class, categoryID);
		return category;
	}

	@Override
	public List<Product> allProducts() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();

		List<Product> list = session.createQuery("from Product").list();

		return list;
	}

	@Override
	public Product findProductByID(int productID) {
		Product product = null;
		Session session = sessionFactory.openSession();
		product = (Product) session.get(Product.class, productID);
		return product;
	}

}
