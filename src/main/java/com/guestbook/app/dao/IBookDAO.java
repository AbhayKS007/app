package com.guestbook.app.dao;

import com.guestbook.app.entity.Guest;

import java.util.List;

public interface IBookDAO {

	List<Guest> getBooks();
	Guest getBook(int guestId);
	Guest setApproval(int guestId, String value);
	Guest createBook(Guest book);
	boolean deleteBook(int bookId);

}
