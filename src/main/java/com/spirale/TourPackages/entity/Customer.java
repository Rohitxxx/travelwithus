package com.spirale.TourPackages.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	@NotBlank(message="name is required")
	private String name;
	
	
	@NotBlank(message="email is required")
	@Email(message="invalid email fromat")
	@Column( unique=true)
	private String email;
	
	@NotBlank(message="Password is required")
	/* @Size(min=4, max=20,message="Password must be between 8 to 20 characters") */
	private String password;
	
	@NotBlank(message="confirm Password is required")
	private String confirmPassword;
	
	 public Customer(Integer customerId, String name, String email, String password, String confirmPassword,
			Set<Booking> bookingList) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.bookingList = bookingList;
	}

	  
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(Set<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	@OneToMany( targetEntity = Booking.class,cascade= CascadeType.ALL)
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
				+ ", confirmPassword=" + confirmPassword + ", bookingList=" + bookingList + "]";
	}

	public Customer() {

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

	
}
