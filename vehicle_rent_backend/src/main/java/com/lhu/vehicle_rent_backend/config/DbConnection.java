package com.lhu.vehicle_rent_backend.config;

import org.hibernate.cfg.Configuration;

import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;

public class DbConnection {
	private DbConnection() {
	}

	private static DbConnection dbConnection = new DbConnection();

	public static DbConnection getInstance() {
		if (dbConnection == null)
			dbConnection = new DbConnection();
		return dbConnection;
	}

	public Configuration getConnection() {
		return new Configuration().configure().addAnnotatedClass(User.class).addAnnotatedClass(Vehicle.class)
				.addAnnotatedClass(Book.class);

	}
}
