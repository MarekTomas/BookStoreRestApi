package bookstore.service;

import java.util.List;

import bookstore.model.Books;

public interface BooksService {
	
	public List<Books> getBooks();
	
	public void saveBooks(Books  theBooks);
	
	public Books getBooks(int theId);
	
	public void deleteBooks(int theId);
	
	

}
