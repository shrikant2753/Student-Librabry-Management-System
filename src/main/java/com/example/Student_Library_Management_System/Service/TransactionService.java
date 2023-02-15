package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDto;
import com.example.Student_Library_Management_System.Enums.TransactionStatus;
import com.example.Student_Library_Management_System.Model.Book;
import com.example.Student_Library_Management_System.Model.Card;
import com.example.Student_Library_Management_System.Model.Transaction;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBooks(IssuedBookRequestDto issuedBookRequestDto){
        Transaction transaction = new Transaction();

        int bookId = issuedBookRequestDto.getBookId();
        int cardId = issuedBookRequestDto.getCardId();

        if(bookRepository.findById(bookId).get().isIssued()) {
            return "Book is already issued by someone";
        }
        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setFine(50);
        transaction.setTransactionStatus(TransactionStatus.valueOf("SUCCESSFUL"));
        transaction.setIssuedOperation(true);
        transactionRepository.save(transaction);
        book.setIssued(true);
        bookRepository.save(book);
        return "Book Issued Successfully";
    }

}
