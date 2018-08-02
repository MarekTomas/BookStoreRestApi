package bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bookstore.model.Books;
import bookstore.service.BooksService;

@RestController
@RequestMapping("/api")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@GetMapping("/books")
	public List<Books> getBooks() {
		return booksService.getBooks();
	}
	@GetMapping("/books/{booksId}")
	public Books getBooks(@PathVariable int BooksId) {

		Books theBooks = booksService.getBooks(BooksId);
		return theBooks;

	}
	
	
}
