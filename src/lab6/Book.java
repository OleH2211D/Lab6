package lab6;

import java.time.LocalDate;

public class Book {
    private int id;
    private String name;
    private String author;
    private String edition;
    private LocalDate date;
    private int pages;
    private double price;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(int id, String name, String author, String edition, LocalDate date, int pages, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.edition = edition;
        this.date = date;
        this.pages = pages;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", edition='" + edition + '\'' +
                ", date=" + date +
                ", pages=" + pages +
                ", price=" + price +
                '}';
    }

    public String toFile() {
        return
                        id + "|"+
                        name + "|" +
                        author + "|" +
                        edition + "|" +
                        date + "|"+
                        pages + "|" +
                        price + "\n" ;

    }
}
