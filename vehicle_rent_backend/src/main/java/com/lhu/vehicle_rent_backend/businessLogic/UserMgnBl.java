package com.lhu.vehicle_rent_backend.businessLogic;

import java.util.List;

import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;

public interface UserMgnBl {
	
	public User getUser(String email,String password);
	public User addUser(User user);
	public User updateUser(User user);
	public User deleteUser(User user);
	public List<User> getUsers();
	
	public void addVehicle(Vehicle vehicle);
	public Vehicle getVehicle(int id);
	public List<Vehicle> getVehicles();
	//public User updateVehicle(Vehicle vehicle);
	//public User deleteVehicle(Vehicle vehicle);
	//public List<Vehicle> getVehicles();
}
