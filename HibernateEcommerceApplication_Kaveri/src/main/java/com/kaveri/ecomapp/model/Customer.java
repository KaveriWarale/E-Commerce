package com.kaveri.ecomapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Customer {

	/*
	 * @Id
	 * 
	 * @GenericGenerator(name = "customId", strategy =
	 * "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
	 * 
	 * @Parameter(name = "initial_value", value = "1001"), @Parameter(name =
	 * "increment_size", value = "1") })
	 * 
	 * @GeneratedValue(generator = "customId")
	 */

	@Id
	@GeneratedValue
	private int customerID;

	
	private String customerName;

	private String customerEmail;

	private String customerPassword;

	private long customerContact;

	private String customerAddress;

	@Lob
	@Column(columnDefinition = "mediumblob")
	private String customerImage;

	private String userType;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerName, String customerEmail, String customerPassword, long customerContact,
			String customerAddress, String customerImage, String userType) {
		super();
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerContact = customerContact;
		this.customerAddress = customerAddress;
		this.customerImage = customerImage;
		this.userType = userType;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public long getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(long customerContact) {
		this.customerContact = customerContact;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", customerName=" + customerName + ", customerEmail="
				+ customerEmail + ", customerPassword=" + customerPassword + ", customerContact=" + customerContact
				+ ", customerAddress=" + customerAddress + ", customerImage=" + customerImage + "]";
	}

}
