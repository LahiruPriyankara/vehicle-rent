package com.lhu.vehicle_rent_backend.DTO;
// Generated Aug 15, 2020 8:20:18 PM by Hibernate Tools 4.3.1.Final

import java.util.UUID;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;
import javax.persistence.Transient;

import javax.persistence.ManyToOne;
import org.springframework.web.multipart.MultipartFile;

/**
 * Vehicle generated by hbm2java
 */
@Entity
// @Table(name = "vehicle", catalog = "vehicle_rent")
public class Vehicle implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// default constructor
	public Vehicle() {
		this.image = "UIMG" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	
	@ManyToOne
	private User user = new User();
	
	private String name = "";
	private String vType = "";
	private String image = "";
	private String rate = "";
	private String perKm = "";
	private String perDay = "";
	private String vNumber = "";
	private String conditions = "";

	@Transient
	private MultipartFile file;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getvType() {
		return vType;
	}

	public void setvType(String vType) {
		this.vType = vType;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getPerKm() {
		return perKm;
	}

	public void setPerKm(String perKm) {
		this.perKm = perKm;
	}

	public String getPerDay() {
		return perDay;
	}

	public void setPerDay(String perDay) {
		this.perDay = perDay;
	}

	public String getvNumber() {
		return vNumber;
	}

	public void setvNumber(String vNumber) {
		this.vNumber = vNumber;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", User=" + this.user.toString() + ", name=" + name + ", vType=" + vType + ", image=" + image
				+ ", rate=" + rate + ", perKm=" + perKm + ", perDay=" + perDay + ", vNumber=" + vNumber
				+ ", conditions=" + conditions + ", file=" + file + "]";
	}

	
	
}