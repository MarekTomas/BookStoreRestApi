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

	// autowired booksService
	@Autowired
	private BooksService booksService;

	//add mapping for GET/books
	@GetMapping("/books")
	public List<Books> getBooks() {
		return booksService.getBooks();
	}

	//add mapping for GET/books/{booksId}
	@GetMapping("/books/{booksId}")
	public Books getBooks(@PathVariable int booksId) {

		Books theBooks = booksService.getBooks(booksId);

		if (theBooks == null) {
			throw new BooksNotFoundException("Books id not found " + booksId);
		}
		return theBooks;

	}
	//add mapping POST/books - add new book
	@PostMapping("/books")
	public Books addBooks(@RequestBody Books theBooks) {

		theBooks.setId(0);
		booksService.saveBooks(theBooks);
		return theBooks;
	}

	//add mapping PUT/books - update record 
	@PutMapping("/books")
	public Books updateBooks(@RequestBody Books theBooks) {

		booksService.saveBooks(theBooks);
		return theBooks;
	}
	
	//add mapping DELETE/books/{booksId} - delete record
	@DeleteMapping("/books/{booksId}")
	public String deleteBooks(@PathVariable int booksId) {

		Books theBooks = booksService.getBooks(booksId);
		if (theBooks == null) {
			throw new BooksNotFoundException("Books id not found " + booksId);
		}

		booksService.deleteBooks(booksId);
		return "Delete Books id " + booksId;

	}
}
