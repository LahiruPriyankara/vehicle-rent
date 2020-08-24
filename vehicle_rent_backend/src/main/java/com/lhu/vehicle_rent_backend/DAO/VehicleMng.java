package com.lhu.vehicle_rent_backend.DAO;

import java.util.List;

import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;

public interface VehicleMng {
	public boolean modifyVehicle(Vehicle vehicle, int actionType);

	public Vehicle getVehicle(int id);

	public List<Vehicle> getVehicles(User user);

	//public List<Vehicle> getVehiclesByUser(User user);
}
