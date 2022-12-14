package org.example.entities;

import java.util.List;

public class Library {
    private Book book;
    private User user;
    private Librarian librarian;

    public Library(Book book, User user, Librarian librarian) {
        this.book = book;
        this.user = user;
        this.librarian = librarian;
    }

    public Library() {
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    @Override
    public String toString() {
        return "Library{" +
                "book=" + book +
                ", user=" + user +
                ", librarian=" + librarian +
                '}';
    }
}
