package com.lhu.vehicle_rent_backend.DAO;

import java.util.List;

import com.lhu.vehicle_rent_backend.DTO.Book;
import com.lhu.vehicle_rent_backend.DTO.User;

public interface BookMng {
	public boolean  modifyBook(Book book, int actionType);

	public Book getBook(int id);

	public List<Book> getBooks(User user);
}
