package com.lhu.vehicle_rent_backend.DAOImpl;

import java.util.ArrayList;
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
	public List<Vehicle> getVehicles(User user) {
		try {
			log.debug("Enter | getVehicles");
			session = DbConfig.sessionBulder();
			Query query = null;
			if(user == null){
				query = session.createQuery("from Vehicle");
			}else{
				query = session.createQuery("from Vehicle where user.id ="+user.getId());
			}
			List<Vehicle> list = query.list();
			log.debug("Info | getVehicles list.size() : " + list.size());
			return list;
		} catch (Exception e) {
			return new ArrayList<Vehicle>();
		} finally {
			log.debug("Left | getVehicles");
			session.close();
		}
	}
	@Override
	public List<Vehicle> getVehicles(String rangeVal,String searchVal) {
		try {
			log.debug("Enter | getVehicles");
			session = DbConfig.sessionBulder();
			Query query = null;
			String hqlQuery = "from Vehicle";
			boolean isRangeGiven = ((rangeVal != null)&&(!rangeVal.equalsIgnoreCase("")))? true:false;
			
			if(isRangeGiven){
				hqlQuery = hqlQuery + " where perDay='"+rangeVal+"'";
			}
			if((searchVal != null)&&(!searchVal.equalsIgnoreCase(""))){
				if(isRangeGiven){
					hqlQuery = hqlQuery + " and name='"+searchVal+"'";
				}else{
				    hqlQuery = hqlQuery + " where name='"+searchVal+"'";
				}
			}
			query = session.createQuery(hqlQuery);
			List<Vehicle> list = query.list();
			log.debug("Info | getVehicles list.size() : " + list.size());
			return list;
		} catch (Exception e) {
			return new ArrayList<Vehicle>();
		} finally {
			log.debug("Left | getVehicles");
			session.close();
		}
	}
}
