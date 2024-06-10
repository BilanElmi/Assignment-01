/*
 * Student Name:  Bilan Elmi
 * Lab Professor:  M. Paulo
 * Due Date:  09th June 2024
 * Description:  BookList Class(24S)
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class BookList {
    private ArrayList<Book> bestsellers = new ArrayList<>();
    private final int NUMCOLS = 7; // Assuming there are 7 columns in CSV
    private String[] title = new String[NUMCOLS];
    private final String[] DEFAULT_TITLE = {"Index", "Name", "Author(s)", 
    		"Original language", "First published", "Approximated sales in millions", "Genre"};

    public BookList() {
        for (int i = 0; i < NUMCOLS; i++) {
            title[i] = DEFAULT_TITLE[i];}}

    public String[] lineReader(String line) {
        return line.split(",");}

    public void createList(String fileName) throws BookException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = lineReader(line);
                	if (data.length != NUMCOLS) continue;
                	int index = Integer.parseInt(data[0]);
                	String name = data[1];
                	String author = data[2];
                	String originalLanguage = data[3];
                	int firstPublished = Integer.parseInt(data[4]);
                	float milionSales = Float.parseFloat(data[5]);
                	String genre = data[6];
                	bestsellers.add(new Book(index, name, author, originalLanguage, 
                		firstPublished, milionSales, genre));}
        } catch (IOException e) {
            throw new BookException("Failed to read file: " + e.getMessage());}
    }

    public void saveList(String fileName) throws BookException, IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Book book : bestsellers) {
                bw.write(book.getIndex() + "," + book.getName() + "," + book.getAuthor() + 
                		"," + book.getOriginalLanguage() + "," + book.getFirstPublished() +
                		"," + book.getMillionSales() + "," + book.getGenre());
                bw.newLine();}
        } catch (IOException e) {
            throw new BookException("Failed to save file: " + e.getMessage());
        }
    }

    public void printList() {
        for (Book book : bestsellers) {
            System.out.println(book);}}

    public void edit(int index, Book book) {
        bestsellers.set(index, book);}

    public Book findBookByIndex(int index) {
        return bestsellers.get(index);}

    public int getSize() {
        return bestsellers.size();}

    public void add(Book book) {
        bestsellers.add(book);}

    public void delete(int index) {
        bestsellers.remove(index);}

    public void search(String data) {
        for (Book book : bestsellers) {
            if (book.getName().contains(data) || 
            		book.getAuthor().contains(data) || book.getOriginalLanguage().contains(data) 
            		|| book.getGenre().contains(data)) {
                System.out.println(book);
            }
        }
    }
}



