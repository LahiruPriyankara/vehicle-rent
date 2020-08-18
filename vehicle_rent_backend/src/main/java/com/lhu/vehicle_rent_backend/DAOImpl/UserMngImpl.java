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
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.config.DbConfig;

@Repository("userMng")
@Transactional
public class UserMngImpl implements UserMng {

	private static final Log log = LogFactory.getLog(UserMngImpl.class);
	Session session;
	Query query = null;

	@Override
	public User getUser(String email, String password) {
		try {
			log.debug("Enter | getUser");
			session = DbConfig.sessionBulder();
			if (password == null) {
				query = session.createQuery("from User where email =?");
				query.setParameter(0, email);
			} else {
				query = session.createQuery("from User where email =? and password=?");
				query.setParameter(0, email);
				query.setParameter(1, password);
			}

			return (User) query.uniqueResult();
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getUser");
			session.close();
		}
	}

	@Override
	public User modifyUser(User user, int actionType) {

		log.debug("Enter | modifyUser");
		try {
			log.debug("Info | USER : " + user.toString());
			session = DbConfig.sessionBulder();

			Transaction tx = session.beginTransaction();
			if (actionType == 1) {
				session.save(user);
			} else if (actionType == 2) {
				session.update(user);
			} else if (actionType == 3) {
				session.delete(user);
			} else {
				throw new Exception("Invalid Action Type");
			}

			session.getTransaction().commit();
			log.debug("persist successful");
			return user;
		} catch (Exception e) {
			log.error("persist failed", e);
			return null;
		} finally {
			log.debug("Left | modifyUser");
			session.close();
		}
	}

	@Override
	public List<User> getUsers() {
		try {
			log.debug("Enter | getUsers");
			session = DbConfig.sessionBulder();
			query = session.createQuery("from User");
			List<User> list = query.list();
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getUsers");
			session.close();
		}
	}

}
