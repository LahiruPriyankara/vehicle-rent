package com.lhu.vehicle_rent_backend.DAO;

import java.util.List;

import com.lhu.vehicle_rent_backend.DTO.User;

public interface UserMng {
	public User getUser(String email,String password);
	public User modifyUser(User user,int actionType);
	public List<User> getUsers();
}
