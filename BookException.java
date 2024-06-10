/*
 * Student Name:  Bilan Elmi
 * Lab Professor:  M. Paulo
 * Due Date:  09th June 2024
 * Description:  BookException Class(24S)
 */
	public class BookException extends Exception {
	public BookException(String errorMessage) {
        super(errorMessage);
        System.err.println("BookException: " + errorMessage);
    }
}
