package com.lhu.vehicle_rent_backend.DTO;
// Generated Aug 15, 2020 8:20:18 PM by Hibernate Tools 4.3.1.Final

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "appUser", catalog = "vehicle_rent")
public class User implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id = 0;
	@NotBlank(message = "Please enter the email")
	private String email = "";
	@Column(name = "u_name")
	@NotBlank(message = "Please enter the name")
	private String name = "";
	@NotBlank(message = "Please enter the password")
	private String password = "";
	@NotBlank(message = "Please enter the telephone")
	private String tp = "";
	@NotBlank(message = "Please enter the role")
	private String role = "";
	@NotBlank(message = "Please enter the image")
	private String image = "";
	@NotBlank(message = "Please enter the status")
	private String status = "";

	@Transient
	@JsonIgnore
	private String confirmPassword = "";

	@Transient
	@JsonIgnore
	private String confirmPassword2 = "";

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Vehicle> vehicle = new ArrayList<Vehicle>();

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Book> book = new ArrayList<Book>();

	@Transient
	@JsonIgnore
	private MultipartFile file;

	// default constructor
	public User() {
		this.image = "UIMG" + UUID.randomUUID().toString().substring(26).toUpperCase();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTp() {
		return tp;
	}

	public void setTp(String tp) {
		this.tp = tp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getConfirmPassword2() {
		return confirmPassword2;
	}

	public void setConfirmPassword2(String confirmPassword2) {
		this.confirmPassword2 = confirmPassword2;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", tp=" + tp + ", role=" + role
				+ ", image=" + image + ", status=" + status + ", confirmPassword=" + confirmPassword + ", file=" + file
				+ ", name=" + name + "]";
	}

	public String to_String() {
		String vehicleStr = vehicle != null ? vehicle.toString() : "NULL";
		String bookStr = book != null ? book.size() + "" : "NULL";

		return "User [id=" + id + ", email=" + email + ", tp=" + tp + ", role=" + role
				+ ", image=" + image + ", status=" + status + ", confirmPassword=" + confirmPassword + ", vehicle="
				+ vehicleStr + ", book=" + bookStr + ", file=" + file + ", name=" + name + "]";
	}

}
