package com.guestbook.app.services;

import com.guestbook.app.entity.Guest;

import java.util.List;

public interface IBookService {
	
	List<Guest> getBooks();
	Guest createBook(Guest guest);
  	Guest getBook(int bookId);
	Guest setApproval(int guestId, String value);
	boolean deleteBook(int bookId);

}
