package com.guestbook.app.dao;

import com.guestbook.app.entity.Guest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Transactional
@Repository
public class BookDAO implements IBookDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Guest> getBooks() {

		String hql = "FROM Guest";
		System.out.println(entityManager.createQuery(hql).getResultList());
		return (List<Guest>) entityManager.createQuery(hql).getResultList();
	}

	@Override
	public Guest getBook(int bookId) {

		return entityManager.find(Guest.class, bookId);
	}

	@Override
	public Guest setApproval(int guestId, String value) {
		Guest bookFromDB = getBook(guestId);
		bookFromDB.setApproved(value);
		return entityManager.find(Guest.class, guestId);
	}
	@Override
	public Guest createBook(Guest book) {
		book.setRole("guest");
		entityManager.persist(book);
        return getLastInsertedBook();
	}


	@Override
	public boolean deleteBook(int bookId) {
		Guest guest = getBook(bookId);
		entityManager.remove(guest);

		//we are checking here that whether entityManager contains earlier deleted book or not
		// if contains then book is not deleted from DB that's why returning false;
		boolean status = entityManager.contains(guest);
		if(status){
			return false;
		}
		return true;
	}
	private Guest getLastInsertedBook(){
		String hql = "from Guest order by id DESC";
		Query query = entityManager.createQuery(hql);
		query.setMaxResults(1);
        return (Guest) query.getSingleResult();
	}

}
