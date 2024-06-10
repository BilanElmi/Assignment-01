/*
 * Student Name:  Bilan Elmi
 * Lab Professor:  M. Paulo
 * Due Date:  09th June 2024
 * Description:  Book Class(24S)
 */

public class Book {
    private int index;
    private String name;
    private String author;
    private String originalLanguage;
    private int firstPublished;
    private float millionSales;
    private String genre;

    public Book(int index, String name, String author, String originalLanguage, int firstPublished, float millionSales, String genre) {
        this.index = index;
        this.name = name;
        this.author = author;
        this.originalLanguage = originalLanguage;
        this.firstPublished = firstPublished;
        this.millionSales = millionSales;
        this.genre = genre;
    }

    public void setIndex(int index) {
        this.index = index;}

    public int getIndex() {
        return index;}

    public String getName() {
        return name;}

    public String getAuthor() {
        return author;}

    public String getOriginalLanguage() {
        return originalLanguage;}

    public int getFirstPublished() {
        return firstPublished;}

    public float getMillionSales() {
        return millionSales;}

    public String getGenre() {
        return genre;}

    public void setGenre(String genre) {
        this.genre = genre;}

    public String toString() {
        return index + ", " + name + ", " + author + ", " + originalLanguage + ", " + firstPublished + ", " + millionSales + ", " + genre;}
}

