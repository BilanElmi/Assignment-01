/*
 * Student Name:  Bilan Elmi
 * Lab Professor:  M. Paulo
 * Due Date:  09th June 2024
 * Description:  BookManager Class(24S)
 */


import java.util.Scanner;

public class BookManager {
    private final int OPTION1_CRT = 1;
    private final int OPTION2_LST = 2;
    private final int OPTION3_ADD = 3;
    private final int OPTION4_EDT = 4;
    private final int OPTION5_DEL = 5;
    private final int OPTION6_SAV = 6;
    private final int OPTION7_SRC = 7;
    private final int OPTION8_EXT = 8;
    private final int FIRST_OPTION = 1;
    private final int LAST_OPTION = 8;
    private final String TITLE = "|| Menu – Best Sellers OOP/Assignment1 ||";
    private String fileName = "src\\best-selling-books.csv";
    private BookList booklist = new BookList();
    private static Scanner input = new Scanner(System.in);

    public BookManager() {}

  //Option 1
    public void createBookList() throws BookException {
        try {
            booklist.createList(fileName);
            System.out.println("Book list created successfully!");
        } catch (Exception e) {
            throw new BookException("Failed to create book list: " + e.getMessage());}
    }


//Option 2
    public void showBookList() {
        booklist.printList();
    }

// Option 3
    public void addBook() throws BookException {
        Book book = createBook(booklist.getSize());
        booklist.add(book);
        System.out.println("Book added successfully.");
    }
    
    //Option 4
    public void editBook() throws BookException {
        System.out.print("Enter the index for the book to edit: ");
        int index = input.nextInt();
        Book book = createBook(index);
        booklist.edit(index, book);
        System.out.println("Book edited successfully.");
    }

// Option 5
    public void deleteBook() throws BookException {
        System.out.print("Enter the index for the book to delete: ");
        int index = input.nextInt();
        booklist.delete(index);
        System.out.println("Book deleted successfully.");
    }

  //Option 6
    public void saveBookList() throws BookException {
        try {
            booklist.saveList(fileName);
            System.out.println("File " + fileName + " created.");
        } catch (Exception e) {
            throw new BookException("Failed to save book list: " + e.getMessage());
        }
    }
    
    //Option 7
    public void search() throws BookException {
        System.out.print("Enter one string for search in the list: ");
        String data = input.next();
        booklist.search(data);
    }

    //Option 3 - to add a book
    public Book createBook(int index) throws BookException {
        input.nextLine();
        System.out.print("- Name: ");
        String name = input.nextLine();
        System.out.print("- Author: ");
        String author = input.nextLine();
        System.out.print("- Original Language: ");
        String originalLanguage = input.nextLine();
        System.out.print("- First Published: ");
        int firstPublished = input.nextInt();
        System.out.print("- Million of Sales: ");
        float milionSales = input.nextFloat();
        input.nextLine(); // Consume newline
        System.out.print("- Genre: ");
        String genre = input.nextLine();

        if (name.isEmpty() || author.isEmpty() || originalLanguage.isEmpty() || firstPublished <= 0 || firstPublished > 2024 || milionSales < 0) {
            throw new BookException("Invalid book data.");
        
        }
        return new Book(index, name, author, originalLanguage, firstPublished, milionSales, genre);
    }

    public void showMenu() {
        System.out.println("================================");
        System.out.println(TITLE);
        System.out.println("================================");
        System.out.println("1. Create Booklist");
        System.out.println("2. Show Booklist");
        System.out.println("3. Add book");
        System.out.println("4. Edit a book");
        System.out.println("5. Delete a book");
        System.out.println("6. Save booklist");
        System.out.println("7. Search in the list");
        System.out.println("8. Exit");
        System.out.print("Choose an option: ");
    }

    public void exit() {
        System.out.println("================================");
        System.out.println("|| [Application ended] ||");
        System.out.println("================================");
        System.exit(0);
    }

    public void manageBookList() throws BookException {
        System.out.println("================================");
        System.out.println("|| Program made by Bilan Elmi  ||");
        System.out.println("================================");
        while (true) {
            showMenu();
            int option;
            try {
                option = input.nextInt();
            } catch (Exception e) {
                input.nextLine(); // Clear invalid input
                throw new BookException("Invalid entry: enter an integer between 1 and 8.");
            }
            	if (option < FIRST_OPTION || option > LAST_OPTION) {
            		throw new BookException("Invalid entry: enter an integer between 1 and 8.");
            	}	
            switch (option) {
                case OPTION1_CRT:
                    createBookList();
                    break;
                    
                case OPTION2_LST:
                    showBookList();
                    break;
                    
                case OPTION3_ADD:
                    addBook();
                    break;
                    
                case OPTION4_EDT:
                    editBook();
                    break;
                    
                case OPTION5_DEL:
                    deleteBook();
                    break;
                    
                case OPTION6_SAV:
                    saveBookList();
                    break;
                    
                case OPTION7_SRC:
                    search();
                    break;
                    
                case OPTION8_EXT:
                    exit();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        try {
            manager.manageBookList();
        } catch (BookException e) {
            System.err.println("BookException: " + e.getMessage());
        }
    }
}

