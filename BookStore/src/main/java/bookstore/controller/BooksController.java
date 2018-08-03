package bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping("/books")
	public Books addBooks(@RequestBody Books theBooks) {
		theBooks.setId(0);
		booksService.saveBooks(theBooks);
		return theBooks;
	}

	@PutMapping("/books")
	public Books updateBooks(@RequestBody Books theBooks) {
		booksService.saveBooks(theBooks);
		return theBooks;
	}

	@DeleteMapping
	public String deleteBooks(@PathVariable int BooksId) {
		booksService.deleteBooks(BooksId);
		return "Delete Books id "+ BooksId;

	}
}
