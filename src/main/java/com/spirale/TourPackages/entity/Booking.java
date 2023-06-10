package com.spirale.TourPackages.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingId;
	private String totalAmount;
	private String bookingDate;
	private Integer noOfTravelers;
	private String paymentMode;
	private String bookingStatus;
	private String paymentStatus;
	
	/*
	 * @OneToOne
	 * 
	 * @JoinColumn(name="customerId") private Customer customer;
	 * 
	 * @OneToOne
	 * 
	 * @JoinColumn(name="travelPackagesId") private TravelPackages travelPackages;
	 */
	
	public Booking() {
		
	}
	public Booking(Integer bookingId, String totalAmount, String bookingDate, Integer noOfTravelers,
			String paymentMode, String bookingStatus, String paymentStatus) {
		super();
		this.bookingId = bookingId;
		this.totalAmount = totalAmount;
		this.bookingDate = bookingDate;
		this.noOfTravelers = noOfTravelers;
		this.paymentMode = paymentMode;
		this.bookingStatus = bookingStatus;
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", totalAmount=" + totalAmount + ", bookingDate=" + bookingDate
				+ ", noOfTravelers=" + noOfTravelers + ", paymentMode=" + paymentMode + ", bookingStatus="
				+ bookingStatus + ", paymentStatus=" + paymentStatus + "]";
	}
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Integer getNoOfTravelers() {
		return noOfTravelers;
	}
	public void setNoOfTravelers(Integer noOfTravelers) {
		this.noOfTravelers = noOfTravelers;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
