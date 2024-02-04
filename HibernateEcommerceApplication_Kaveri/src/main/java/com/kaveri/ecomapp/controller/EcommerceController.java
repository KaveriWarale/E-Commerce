package com.kaveri.ecomapp.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import com.kaveri.ecomapp.dao.EcommerceDao;
import com.kaveri.ecomapp.dao.EcommerceDaoImpl;
import com.kaveri.ecomapp.model.Category;
import com.kaveri.ecomapp.model.Customer;
import com.kaveri.ecomapp.model.Product;
import com.kaveri.ecomapp.service.EcommerceService;
import com.kaveri.ecomapp.service.EcommerceServiceImpl;

@WebServlet("/EcommerceController")
@MultipartConfig
//@MultipartConfig(maxFileSize = 16177215)
public class EcommerceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static final String SIGNUP_PAGE = "customer_register.jsp";
	public static final String SIGNIN_PAGE = "login.jsp";
	public static final String CUSTOMER_DASHBOARD_PAGE = "customer_dashboard.jsp";
	public static final String ADMIN_DASHBOARD_PAGE = "admin_dashboard.jsp";
	public EcommerceService ecommerceServiceImpl = new EcommerceServiceImpl();

	public String redirect = "";

	public EcommerceController() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		HttpSession httpSession = request.getSession();
		if (action.equals("signUp")) {
			String ts="";
			String customerName = request.getParameter("customerName");
			String customerEmail = request.getParameter("customerEmail");
			String customerPassword = request.getParameter("customerPassword");
			long customerContact = Long.valueOf(request.getParameter("customerContact"));
			String customerAddress = request.getParameter("customerAddress");

			
			Part file = request.getPart("customerPhoto");
			InputStream filecontent = file.getInputStream();
			byte[] sourceBytes = IOUtils.toByteArray(filecontent);
			
			String encodedString = Base64.getEncoder().encodeToString(sourceBytes);

			Customer customer = new Customer(customerName, customerEmail, customerPassword, customerContact,
					customerAddress, encodedString, "user");
			EcommerceDao ecommerceDao=new EcommerceDaoImpl();
			
			if (ecommerceDao.saveCustomer(customer)) {
				httpSession.setAttribute("success_message", "Registration Done Successfully, Please Sign In..!!!");
				redirect = SIGNIN_PAGE;
			} else {
				httpSession.setAttribute("error_message", "Registration fail, Email Available..!!");
				redirect = SIGNUP_PAGE;
			}
		} else if (action.equals("signIn")) {
			String customerEmail = request.getParameter("customerEmail");
			String customerPassword = request.getParameter("customerPassword");
			
			Customer customer = ecommerceServiceImpl.signIn(customerEmail, customerPassword);			

			if (customer == null) {
				httpSession.setAttribute("error_message", "Invalid Credetials..!! Please Try Again...");
				redirect = SIGNIN_PAGE;
			} else {
				httpSession.setAttribute("current_user", customer);
				// System.out.println("WELCOME " + customer.getCustomerName());
				if (customer.getUserType().equals("admin")) {
					redirect = ADMIN_DASHBOARD_PAGE;
				} else if (customer.getUserType().equals("user")) {
					redirect = CUSTOMER_DASHBOARD_PAGE;
				} else {
					httpSession.setAttribute("error_message", "Invalid Credetials..!! Please Try Again...");
					redirect = SIGNIN_PAGE;
				}
			}
		} else if (action.equals("addCategory")) {
			String categoryName = request.getParameter("categoryName");
			String categoryDes = request.getParameter("categoryDes");

			Category category = new Category();
			category.setCategoryName(categoryName);
			category.setCategoryDescription(categoryDes);

			ecommerceServiceImpl.saveCategory(category);

			httpSession.setAttribute("success_message", " Category Added Successfully..!!!");
			response.sendRedirect(ADMIN_DASHBOARD_PAGE);
			// redirect = ADMIN_DASHBOARD_PAGE;
			return;

		} else if (action.equals("addProducts")) {

			String productName = request.getParameter("productName");
			String productDescription = request.getParameter("productDescription");

			Part file = request.getPart("productPhoto");
			InputStream filecontent = file.getInputStream();
			byte[] sourceBytes = IOUtils.toByteArray(filecontent);
			String productPhoto = Base64.getEncoder().encodeToString(sourceBytes);

			String productColor = request.getParameter("productColor");
			int productPrice = Integer.valueOf(request.getParameter("productPrice"));
			int productDiscount = Integer.valueOf(request.getParameter("productDiscount"));
			int productQuantity = Integer.valueOf(request.getParameter("productQuantity"));
			int productCategoryID = Integer.valueOf(request.getParameter("productCategory"));

			/*
			 * Category category = (Category) ecommerceServiceImpl.allCategory().stream()
			 * .filter(c -> c.getCategoryId() == productCategoryID).toList();
			 */
			Category category = ecommerceServiceImpl.findCategoryByID(productCategoryID);
			Product product = new Product();
			product.setProductName(productName);
			product.setProductDescription(productDescription);
			product.setProductPhoto(productPhoto);
			product.setProductColor(productColor);
			product.setProductPrice(productPrice);
			product.setProductDiscount(productDiscount);
			product.setProductQuantity(productQuantity);
			product.setCategory(category);

			ecommerceServiceImpl.saveProducts(product);
			httpSession.setAttribute("success_message", " Product Added Successfully..!!!");
			response.sendRedirect(ADMIN_DASHBOARD_PAGE);
			// redirect = ADMIN_DASHBOARD_PAGE;
			return;

		}
		RequestDispatcher rd = request.getRequestDispatcher(redirect);
		rd.forward(request, response);
	}

}
