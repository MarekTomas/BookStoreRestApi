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
	
	@Autowired
	private SessionFactory sessionFacory;

	@Override
	public List<Books> getBooks() {
		
		Session curentSession = sessionFacory.getCurrentSession();
		
		Query<Books> theQuery = curentSession.createQuery("from Books order by title", Books.class);
		
		List<Books> books = theQuery.getResultList();
		
		return books;
	}

	@Override
	public void saveBooks(Books theBooks) {
		
		Session curentSession = sessionFacory.getCurrentSession();
		
		curentSession.saveOrUpdate(theBooks);
		
	}

	@Override
	public Books getBooks(int theId) {
		
		Session curentSession = sessionFacory.getCurrentSession();
		
		Books theBooks = curentSession.get(Books.class, theId);
		
		return theBooks;
	}

	@Override
	public void deleteBooks(int theId) {
		
		Session curentSession = sessionFacory.getCurrentSession();
		
		Query theQuery = curentSession.createQuery("delete from Books where id=:id");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

}
