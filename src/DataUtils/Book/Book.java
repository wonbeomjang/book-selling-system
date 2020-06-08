package DataUtils.Book;

import DataUtils.User.User;

import java.time.Year;

public abstract class Book {
    protected final String title;
    protected final String isbn;
    protected final Year public_year;
    protected final String publisher;
    protected final String author;
    protected User owner;

    Book(String title, String isbn, Year public_year, String publisher, String author, User owner) {
        this.title = title;
        this.isbn = isbn;
        this.public_year = public_year;
        this.publisher = publisher;
        this.author = author;
        this.owner = owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getOwner() {
        return owner;
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public Year getPublic_year() {
        return public_year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return title + ':' + isbn + ':' + public_year.toString() + ':' + publisher + ':' + author + ':' + " " + ':' + " " + ':' +
                owner.getUsername() + '\n';
    }
}
