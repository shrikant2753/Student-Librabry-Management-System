package com.example.Student_Library_Management_System.Repositories;

import com.example.Student_Library_Management_System.Model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    @Query(value = "Select * from transaction t where t.book_id:bookId and t.card_id:cardId and t.is_issued_operation = true",
    nativeQuery = true)
    List<Transaction> getTransactionForBookAndCard(int bookId, int cardId);



}
