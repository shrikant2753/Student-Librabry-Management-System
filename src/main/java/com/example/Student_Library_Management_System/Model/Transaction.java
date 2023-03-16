package com.example.Student_Library_Management_System.Model;

import com.example.Student_Library_Management_System.Enums.TransactionStatusEnum;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private TransactionStatusEnum transactionStatusEnum;

    private int fine;

    @CreationTimestamp
    private Date transactionDate;

    private boolean isIssuedOperation;

    private String transactionId = UUID.randomUUID().toString();

    //mapping between transaction and books
    //There are many transaction for 1 book, so it ia a ONEtoMANY wrt transaction
    @ManyToOne
    @JoinColumn
    private Book book;//pk of book comes here and become a foreign key

    //Mapping between Transaction and card
    //Here for a one care many transactions are their, so it is a ManyToOne wrt to transaction to card
    @ManyToOne
    @JoinColumn
    private Card card;

    public Transaction(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TransactionStatusEnum getTransactionStatusEnum() {
        return transactionStatusEnum;
    }

    public void setTransactionStatus(TransactionStatusEnum transactionStatusEnum) {
        this.transactionStatusEnum = transactionStatusEnum;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public boolean isIssuedOperation() {
        return isIssuedOperation;
    }

    public void setIssuedOperation(boolean issuedOperation) {
        isIssuedOperation = issuedOperation;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
