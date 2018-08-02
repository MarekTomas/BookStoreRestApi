package bookstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.BooksDao;
import bookstore.model.Books;

@Service
public class BooksServiceImpl implements BooksService {

	@Autowired
	private BooksDao booksDao;

	@Override
	@Transactional
	public List<Books> getBooks() {
		return booksDao.getBooks();
	}

	@Override
	@Transactional
	public void saveBooks(Books theBooks) {
		booksDao.saveBooks(theBooks);

	}

	@Override
	@Transactional
	public Books getBooks(int theId) {
		return booksDao.getBooks(theId);
	}

	@Override
	@Transactional
	public void deleteBooks(int theId) {
		booksDao.deleteBooks(theId);

	}

}
