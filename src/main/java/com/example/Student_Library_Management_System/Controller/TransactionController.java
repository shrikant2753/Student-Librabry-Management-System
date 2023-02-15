package com.example.Student_Library_Management_System.Controller;

import com.example.Student_Library_Management_System.DTOs.IssuedBookRequestDto;
import com.example.Student_Library_Management_System.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/issue-book")
    public String issuedBooks(@RequestBody IssuedBookRequestDto issuedBookRequestDto){
        return transactionService.issueBooks(issuedBookRequestDto);
    }

}
