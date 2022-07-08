package kz.iitu.itse1902.var1_nurkhan.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @Column(name = "book_id")
    private Long bookId;
    @Column(name = "book_name")
    private String name;
    @Column(name = "book_genre")
    private String genre;
    @Column(name = "book_author")
    private String author;

    public Book() {
    }

    public Book(Long bookId, String name, String genre, String author) {
        this.bookId = bookId;
        this.name = name;
        this.genre = genre;
        this.author = author;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
