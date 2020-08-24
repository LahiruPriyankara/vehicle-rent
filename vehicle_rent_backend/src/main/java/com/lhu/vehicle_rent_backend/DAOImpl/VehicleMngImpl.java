package com.lhu.vehicle_rent_backend.DAOImpl;

import java.util.List;

import javax.naming.InitialContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lhu.vehicle_rent_backend.DAO.UserMng;
import com.lhu.vehicle_rent_backend.DAO.VehicleMng;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.DTO.Vehicle;
import com.lhu.vehicle_rent_backend.config.DbConfig;

@Repository("vehicleMngImpl")
@Transactional
public class VehicleMngImpl implements VehicleMng {
	Session session;

	private static final Log log = LogFactory.getLog(VehicleMngImpl.class);

	@Override
	public boolean modifyVehicle(Vehicle vehicle, int actionType) {

		log.debug("Enter | modifyVehicle");
		try {

			session = DbConfig.sessionBulder();

			Transaction tx = session.beginTransaction();
			if (actionType == 1) {
				session.save(vehicle);
			} else if (actionType == 2) {
				session.update(vehicle);
			} else if (actionType == 3) {
				session.delete(vehicle);
			} else {
				throw new Exception("Invalid Action Type");
			}

			session.getTransaction().commit();
			log.debug("persist successful");
			return true;
		} catch (Exception e) {
			log.error("persist failed", e);
			return false;
		} finally {
			log.debug("Left | modifyVehicle");
			session.close();
		}
	}

	@Override
	public Vehicle getVehicle(int id) {
		try {
			log.debug("Enter | getVehicle");
			session = DbConfig.sessionBulder();
			Query query = session.createQuery("from Vehicle where id ="+id);
			Vehicle vehicle = (Vehicle)query.uniqueResult();
			System.out.println("Info | Vehicle : "+vehicle.to_String());
			return vehicle;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getVehicle");
			session.close();
		}
	}

	@Override
	public List<Vehicle> getVehicles() {
		try {
			log.debug("Enter | getVehicles");
			session = DbConfig.sessionBulder();
			Query query = session.createQuery("from Vehicle");
			List<Vehicle> list = query.list();
			log.debug("Info | getVehicles list.size() : " + list.size());
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getVehicles");
			session.close();
		}
	}
	@Override
	public List<Vehicle> getVehiclesByUser(User user) {
		try {
			log.debug("Enter | getVehiclesById");
			session = DbConfig.sessionBulder();
			Query query = session.createQuery("from Vehicle where user.id ="+user.getId());
			List<Vehicle> list = query.list();
			log.debug("Info | getVehicles list.size() : " + list.size());
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getVehiclesById");
			session.close();
		}
	}
}
