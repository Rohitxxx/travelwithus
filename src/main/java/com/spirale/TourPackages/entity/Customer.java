package com.spirale.TourPackages.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	private String name;
	private String email;
	private String password;
	private String  passwordConfirm;
  @OneToMany(cascade= CascadeType.ALL)
  @JoinColumn(name="customerId")
  Set<Booking> bookingList;
	/*
	 * @OneToOne(mappedBy="customer", cascade=CascadeType.ALL) private Booking
	 * booking;
	 */
	
//	@OneToMany(cascade= CascadeType.ALL)
//	@JoinColumn(name="customerId")
//	Set<TravelPackages> travelPackageList; 
	
	
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", passwordConfirm=" + passwordConfirm + "]";
	}
	
	public Customer() {
		
	}
	public Customer(Integer customerId, String name, String email, String password, String passwordConfirm) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirm = passwordConfirm;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	
}
