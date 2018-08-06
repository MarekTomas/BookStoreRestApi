package bookstore.controller;

public class BooksNotFoundException extends RuntimeException {

	public BooksNotFoundException() {
		
	}

	public BooksNotFoundException(String arg0) {
		super(arg0);
		
	}

	public BooksNotFoundException(Throwable arg0) {
		super(arg0);
		
	}

	public BooksNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public BooksNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

}
