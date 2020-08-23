package com.lhu.vehicle_rent_backend.businessLogic;

import java.util.List;

import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;

public interface UserMgnBl {

	public User getUser(String email, String password);

	public boolean addUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUser(User user);

	public List<User> getUsers();

	public boolean addVehicle(Vehicle vehicle);

	public boolean updateVehicle(Vehicle vehicle);

	public boolean deleteVehicle(Vehicle vehicle);

	public Vehicle getVehicle(int id);

	public List<Vehicle> getVehicles();

	public List<Vehicle> getVehiclesByUser(User user);

	public boolean addBook(Book book);

	public boolean updateBook(Book book);

	public boolean deleteBook(Book book);

	public Book getBook(int id);

	public List<Book> getBooks();

	public List<Book> getBooksByUser(User user);
}
