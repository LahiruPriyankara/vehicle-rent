package com.lhu.vehicle_rent_backend.DAOImpl;
// Generated Aug 16, 2020 8:38:22 AM by Hibernate Tools 4.3.1.Final

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lhu.vehicle_rent_backend.DAO.BookMng;
import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;
import com.lhu.vehicle_rent_backend.config.DbConfig;

/**
 * Home object for domain model class Book.
 * 
 * @see com.lhu.vehicle_rent_backend.DTO.Book
 * @author Hibernate Tools
 */
@Repository("bookMngImpl")
@Transactional
public class BookMngImpl implements BookMng {
	Session session;
	private static final Log log = LogFactory.getLog(BookMngImpl.class);

	@Override
	public boolean modifyBook(Book book, int actionType) {

		log.debug("Enter | modifyBook");
		try {

			session = DbConfig.sessionBulder();

			Transaction tx = session.beginTransaction();
			if (actionType == 1) {
				session.save(book);
			} else if (actionType == 2) {
				session.update(book);
			} else if (actionType == 3) {
				session.delete(book);
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
			log.debug("Left | modifyBook");
			session.close();
		}
	}

	@Override
	public Book getBook(int id) {
		try {
			log.debug("Enter | getBook");
			session = DbConfig.sessionBulder();
			Query query = session.createQuery("from Book where id =" + id);
			Book book = (Book) query.uniqueResult();
			System.out.println("Info | Vehicle : " + book.to_String());
			return book;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getBook");
			session.close();
		}
	}

	@Override
	public List<Book> getBooks() {
		try {
			log.debug("Enter | getBooks");
			session = DbConfig.sessionBulder();
			Query query = session.createQuery("from Book");
			List<Book> list = query.list();
			log.debug("Info | getBooks list.size() : " + list.size());
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getBooks");
			session.close();
		}
	}
	
	@Override
	public List<Book> getBooksByUser(User user) {
		try {
			log.debug("Enter | getBooksById");
			session = DbConfig.sessionBulder();
			Query query = session.createQuery("from Book where user =" + user);
			List<Book> list = query.list();
			log.debug("Info | getBooks list.size() : " + list.size());
			return list;
		} catch (Exception e) {
			return null;
		} finally {
			log.debug("Left | getBooksById");
			session.close();
		}
	}

}
