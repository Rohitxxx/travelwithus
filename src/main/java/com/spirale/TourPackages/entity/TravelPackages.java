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

@Entity
public class TravelPackages {

	@Id	
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer packageId;
	
	private String packageName;
	private String destination;
	
	
     @Column(name="description",length=1024)
	private String description;
     
	private String duration;
	private Integer price;
	
	private Integer createdAt;
	private Integer updateAt;
	
	 @OneToMany(cascade= CascadeType.ALL)
	  @JoinColumn(name="packageId")
	  Set<Booking> bookingList;
	
	/*
	 * @OneToOne(mappedBy="travelPackages", cascade=CascadeType.ALL) private Booking
	 * booking;
	 */
	public TravelPackages()
	{
		
	}
	public TravelPackages(Integer packageId, String packageName, String destination, String description, String duration,
			Integer price, Integer createdAt, Integer updateAt) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.destination = destination;
		this.description = description;
		this.duration = duration;
		this.price = price;
		this.createdAt = createdAt;
		this.updateAt = updateAt;
	}
	@Override
	public String toString() {
		return "TravelPackage [packageId=" + packageId + ", packageName=" + packageName + ", destination=" + destination
				+ ", description=" + description + ", duration=" + duration + ", price=" + price + ", createdAt="
				+ createdAt + ", updateAt=" + updateAt + "]";
	}
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Integer createdAt) {
		this.createdAt = createdAt;
	}
	public Integer getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(Integer updateAt) {
		this.updateAt = updateAt;
	}
	
	
	
}
