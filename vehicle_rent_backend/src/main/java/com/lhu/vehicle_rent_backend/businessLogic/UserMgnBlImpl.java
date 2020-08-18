package com.lhu.vehicle_rent_backend.businessLogic;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import com.lhu.vehicle_rent_backend.DAO.UserMng;
import com.lhu.vehicle_rent_backend.DAOImpl.UserMngImpl;
import com.lhu.vehicle_rent_backend.DAOImpl.VehicleMngImpl;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;

@Repository("userMgnBl")
public class UserMgnBlImpl implements UserMgnBl {
	private static final Log log = LogFactory.getLog(UserMgnBlImpl.class);
	
	//@Autowired
	UserMng userMng = new UserMngImpl();
	
	VehicleMngImpl vehicleMng= new VehicleMngImpl();
	
	
	@Override
	public User getUser(String email,String password) {
		log.debug("Enter | addUser");
		return userMng.getUser(email,password);
	}
	
	@Override
	public User addUser(User user) {
		log.debug("Enter | addUser");
		return userMng.modifyUser(user, 1);
	}

	@Override
	public User updateUser(User user) {
		log.debug("Enter | updateUser");
		return userMng.modifyUser(user, 2);
	}

	@Override
	public User deleteUser(User user) {
		log.debug("Enter | deleteUser");
		return userMng.modifyUser(user, 3);
	}

	@Override
	public List<User> getUsers() {
		log.debug("Enter | getUsers");
		return userMng.getUsers();
	}

	@Override
	public void addVehicle(Vehicle vehicle) {
		log.debug("Enter | addVehicle");
		vehicleMng.modifyVehicle(vehicle, 1);
	}
	@Override
	public Vehicle getVehicle(int id) {
		log.debug("Enter | getUsers");
		return vehicleMng.getVehicle(id);
	}
	@Override
	public List<Vehicle> getVehicles() {
		log.debug("Enter | getUsers");
		return vehicleMng.getVehicles();
	}
	
}
