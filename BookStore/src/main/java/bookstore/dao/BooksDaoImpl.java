package bookstore.dao;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import bookstore.model.Books;

@Repository
public class BooksDaoImpl implements BooksDao {

	// autowired the session factory
	@Autowired
	private SessionFactory sessionFacory;

	@Override
	public List<Books> getBooks() {

		// get the current hibernate session
		Session curentSession = sessionFacory.getCurrentSession();

		// create a query  ... sort by title
		Query<Books> theQuery = curentSession.createQuery("from Books order by title", Books.class);

		// execute query and get result list
		List<Books> books = theQuery.getResultList();

		return books;
	}

	@Override
	public void saveBooks(Books theBooks) {
		
		// get current hibernate session
		Session curentSession = sessionFacory.getCurrentSession();
		
		// save/upate the book
		curentSession.saveOrUpdate(theBooks);

	}

	@Override
	public Books getBooks(int theId) {
		
		// get current hibernate session
		Session curentSession = sessionFacory.getCurrentSession();
		
		// read from database using the primary key
		Books theBooks = curentSession.get(Books.class, theId);

		return theBooks;
	}

	@Override
	public void deleteBooks(int theId) {
		
		// get current hibernate session
		Session curentSession = sessionFacory.getCurrentSession();

		// delete object with primary key
		Query theQuery = curentSession.createQuery("delete from Books where id=:booksId");
		theQuery.setParameter("booksId", theId);

		theQuery.executeUpdate();
	}

}
