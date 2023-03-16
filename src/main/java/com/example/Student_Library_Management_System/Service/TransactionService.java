package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDto;
import com.example.Student_Library_Management_System.DTOs.ReturnBookDto;
import com.example.Student_Library_Management_System.Enums.CardStatus;
import com.example.Student_Library_Management_System.Enums.TransactionStatusEnum;
import com.example.Student_Library_Management_System.Model.Book;
import com.example.Student_Library_Management_System.Model.Card;
import com.example.Student_Library_Management_System.Model.Transaction;
import com.example.Student_Library_Management_System.Repositories.BookRepository;
import com.example.Student_Library_Management_System.Repositories.CardRepository;
import com.example.Student_Library_Management_System.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CardRepository cardRepository;

    public String issueBooks(IssuedBookRequestDto issuedBookRequestDto) throws Exception{
        Transaction transaction = new Transaction();

        int bookId = issuedBookRequestDto.getBookId();
        int cardId = issuedBookRequestDto.getCardId();

        Book book = bookRepository.findById(bookId).get();
        Card card = cardRepository.findById(cardId).get();

        //setting the attributes
        transaction.setBook(book);
        transaction.setCard(card);
        transaction.setTransactionId(UUID.randomUUID().toString());
        transaction.setIssuedOperation(true);

        //transaction is currently pending, neither failed not successful
        transaction.setTransactionStatus(TransactionStatusEnum.PENDING);

        //checking for the validations
        if(book==null || book.isIssued()){
            transaction.setTransactionStatus(TransactionStatusEnum.FAILED);
            //saving transaction details here, no need to save it in book cause book is not issued
            transactionRepository.save(transaction);
            throw new Exception("Book is not available");
        }

        if(card==null){
            transaction.setTransactionStatus(TransactionStatusEnum.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card details");
        }

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatusEnum.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Your card is not active");
        }

        //Now transaction will be successful
        transaction.setTransactionStatus(TransactionStatusEnum.valueOf("SUCCESSFUL"));

        //set attributes of books
        book.setIssued(true);
        List<Transaction> listOfTransactionForBooks = book.getListOfTransactionOfBooks();
        listOfTransactionForBooks.add(transaction);

        //set attributes of card
        List<Book> issuesBooksOnCard = card.getBooksIssued();
        issuesBooksOnCard.add(book);

        List<Transaction> listOfTransactionForCards = card.getListOfTransactionOfCards();
        listOfTransactionForCards.add(transaction);

        //save the parent
        cardRepository.save(card);
        //by cascading book and transaction saves automatically

        return "Book Issued Successfully";
    }

    public String returnBook(ReturnBookDto returnBookDto){
        int bookId = returnBookDto.getBookId();
        int cardID = returnBookDto.getCardId();

        Transaction transaction = new Transaction();




        return " ";
    }

}
