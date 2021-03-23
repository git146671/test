package eu.senla.eBookStore.book;

import java.time.LocalDate;

public class Book {
    private final int bookId;
    private final String title;
    private final String author;
    private int price;
    private boolean status;
    private final int publicationYear;
    private String description;
    private int orderRequest;
    private int storeRequest;
    private LocalDate dateOfReceipt;

    public Book(int bookId, String title, String author, int price, int publicationYear, LocalDate dateOfReceipt) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.publicationYear = publicationYear;
        this.orderRequest = 0;
        this.dateOfReceipt = dateOfReceipt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setStoreRequest(int storeRequest) {
        this.storeRequest = storeRequest;
    }

    public int getStoreRequest() {
        return storeRequest;
    }
    public int getPrice() {
        return price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public boolean isStatus() {
        return status;
    }

    public void setOrderRequest(int request) {
        this.orderRequest = request;
    }

    public int getOrderRequest() {
        return orderRequest;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

}
