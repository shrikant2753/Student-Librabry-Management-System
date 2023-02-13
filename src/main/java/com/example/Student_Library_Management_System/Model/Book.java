package com.example.Student_Library_Management_System.Model;

import com.example.Student_Library_Management_System.Enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int pages;
    private boolean issued;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    //book is a child wrt to Author
    //many books has one author, so many to one relationship wrt book
    @ManyToOne
    @JoinColumn//adding an extra attribute to the book table, which is a pk of author acting as a foreign key here
    private Author author;//this is the parent entity with we are connecting
                          //we will use this in parent class as mapped by


    //Book is also a child wrt to card.
    //multiple books are with to same card
    @ManyToOne
    @JoinColumn
    private Card card;

    public Book(){}

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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public boolean isIssued() {
        return issued;
    }

    public void setIssued(boolean issued) {
        this.issued = issued;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
