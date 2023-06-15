package com.example.hotelproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {
@Id
private Integer foodid;
private String foodtype;
private String ordertype;
private String foodtime;
private Integer bookingid;
public Integer getFoodid() {
	return foodid;
}
public void setFoodid(Integer foodid) {
	this.foodid = foodid;
}
public String getFoodtype() {
	return foodtype;
}
public void setFoodtype(String foodtype) {
	this.foodtype = foodtype;
}
public String getOrdertype() {
	return ordertype;
}
public void setOrdertype(String ordertype) {
	this.ordertype = ordertype;
}
public String getFoodtime() {
	return foodtime;
}
public void setFoodtime(String foodtime) {
	this.foodtime = foodtime;
}
public Integer getBookingid() {
	return bookingid;
}
public void setBookingid(Integer bookingid) {
	this.bookingid = bookingid;
}

public Food() {
	
}
@Override
public String toString() {
	return "Food [foodid=" + foodid + ", foodtype=" + foodtype + ", ordertype=" + ordertype + ", foodtime=" + foodtime
			+ ", bookingid=" + bookingid + "]";
}

}
