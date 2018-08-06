package bookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BooksRestExceptionHandler {
	
	//Add an exception handler for CustomerNotFoundException
	@ExceptionHandler
	public ResponseEntity<BooksErrorResponse> handleException(BooksNotFoundException exc){
		
		BooksErrorResponse error = new BooksErrorResponse(
									HttpStatus.NOT_FOUND.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	//Add an exception handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<BooksErrorResponse> handleException(Exception exc){
		
		BooksErrorResponse error = new BooksErrorResponse(
									HttpStatus.BAD_REQUEST.value(),
									exc.getMessage(),
									System.currentTimeMillis());
		
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	

}
