package com.example.Student_Library_Management_System.Model;

import com.example.Student_Library_Management_System.Enums.CardStatus;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private CardStatus cardStatus;

    @CreationTimestamp//Auto timestamp the time when on entry is created
    private Date createdOn;

    @UpdateTimestamp //Sets the time when on entry is updated
    private Date updatedOn;

    //joining card and student table
    @OneToOne
    @JoinColumn
    private Student studentVariableName;//This variable is used in parent class table
    //while doing the bidirectional mapping as a mapped by


    //card is parent wrt book
    //one card can issue many books so one to many relation with books wrt to card
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Book> booksIssued;

    //bidirectional mapping between card and transaction
    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    private List<Transaction> listOfTransactionOfCards = new ArrayList<>();


    public Card() {
        booksIssued = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Student getStudentVariableName() {
        return studentVariableName;
    }

    public void setStudentVariableName(Student studentVariableName) {
        this.studentVariableName = studentVariableName;
    }

    public List<Book> getBooksIssued() {
        return booksIssued;
    }

    public void setBooksIssued(List<Book> booksIssued) {
        this.booksIssued = booksIssued;
    }

    public List<Transaction> getListOfTransactionOfCards() {
        return listOfTransactionOfCards;
    }

    public void setListOfTransactionOfCards(List<Transaction> listOfTransactionOfCards) {
        this.listOfTransactionOfCards = listOfTransactionOfCards;
    }
}
