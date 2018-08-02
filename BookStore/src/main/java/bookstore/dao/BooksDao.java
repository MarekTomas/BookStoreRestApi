package bookstore.dao;

import java.util.List;

import bookstore.model.Books;

public interface BooksDao {
	
	public List<Books> getBooks();
	
	public void saveBooks(Books theBooks);
	
	public Books getBooks(int theId);
	
	public void deleteBooks( int theId);
	
	

}
