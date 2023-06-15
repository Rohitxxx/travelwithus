package com.example.hotel_proj.entity;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Hotel {
	@Id
	private Integer id;
	private Integer hoteltype;
	private String hotelname;
	private Integer hotelrent;
	private String description;
	private Integer discount;
	private String acroom;
	private String non_acroom;
	private Integer roomavailable;
	private Integer occupied;
	private String feedback;
}
	
	