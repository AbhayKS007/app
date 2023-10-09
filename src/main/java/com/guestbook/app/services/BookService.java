package com.guestbook.app.services;

import com.guestbook.app.dao.IBookDAO;
import com.guestbook.app.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookDAO dao;

	@Override
	public List<Guest> getBooks() {
		return dao.getBooks();
	}

	@Override
	public Guest createBook(Guest guest) {
		return dao.createBook(guest);
	}

	@Override
	public Guest getBook(int guestId) {
		return dao.getBook(guestId);
	}

	@Override
	public Guest setApproval(int guestId, String value) {
		return dao.setApproval(guestId, value);
	}

	@Override
	public boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

}
