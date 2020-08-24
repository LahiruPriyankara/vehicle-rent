package com.lhu.vehicle_rent_backend.businessLogic;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lhu.vehicle_rent_backend.DAO.BookMng;
import com.lhu.vehicle_rent_backend.DAO.UserMng;
import com.lhu.vehicle_rent_backend.DAO.VehicleMng;
import com.lhu.vehicle_rent_backend.DAOImpl.BookMngImpl;
import com.lhu.vehicle_rent_backend.DAOImpl.VehicleMngImpl;
import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;

@Repository("userMgnBl")
public class UserMgnBlImpl implements UserMgnBl {
	private static final Log log = LogFactory.getLog(UserMgnBlImpl.class);

	@Autowired
	UserMng userMngImpl;
	@Autowired
	VehicleMng vehicleMngImpl;
	@Autowired
	BookMng bookMngImpl;

	// ---------------------------------------- USER
	// ----------------------------------------
	@Override
	public User getUser(String email, String password) {
		log.debug("Enter | addUser");
		return userMngImpl.getUser(email, password);
	}

	@Override
	public boolean addUser(User user) {
		log.debug("Enter | addUser");
		return userMngImpl.modifyUser(user, 1);
	}

	@Override
	public boolean updateUser(User user) {
		log.debug("Enter | updateUser");
		return userMngImpl.modifyUser(user, 2);
	}

	@Override
	public boolean deleteUser(User user) {
		log.debug("Enter | deleteUser");
		return userMngImpl.modifyUser(user, 3);
	}

	@Override
	public List<User> getUsers() {
		log.debug("Enter | getUsers");
		return userMngImpl.getUsers();
	}

	// ---------------------------------------- VEHICLE
	// ----------------------------------------
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		log.debug("Enter | addVehicle");
		return vehicleMngImpl.modifyVehicle(vehicle, 1);
	}

	@Override
	public Vehicle getVehicle(int id) {
		log.debug("Enter | getVehicle");
		return vehicleMngImpl.getVehicle(id);
	}

	@Override
	public List<Vehicle> getVehicles(User user) {
		log.debug("Enter | getVehicles");
		return vehicleMngImpl.getVehicles(user);
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		log.debug("Enter | updateVehicle");
		return vehicleMngImpl.modifyVehicle(vehicle, 2);
	}

	@Override
	public boolean deleteVehicle(Vehicle vehicle) {
		log.debug("Enter | deleteVehicle");
		return vehicleMngImpl.modifyVehicle(vehicle, 3);
	}

	// ---------------------------------------- BOOKING
	// ----------------------------------------
	@Override
	public boolean addBook(Book book) {
		log.debug("Enter | addBook");
		return bookMngImpl.modifyBook(book, 1);
	}

	@Override
	public boolean updateBook(Book book) {
		log.debug("Enter | updateBook");
		return bookMngImpl.modifyBook(book, 2);
	}

	@Override
	public boolean deleteBook(Book book) {
		log.debug("Enter | deleteBook");
		return bookMngImpl.modifyBook(book, 3);
	}

	@Override
	public Book getBook(int id) {
		log.debug("Enter | getBook");
		return bookMngImpl.getBook(id);
	}

	@Override
	public List<Book> getBooks(User user) {
		log.debug("Enter | getBooks");
		return bookMngImpl.getBooks(user);
	}

}
