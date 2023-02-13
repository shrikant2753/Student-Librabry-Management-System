package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.Model.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(Author author){
        authorRepository.save(author);
        return "Author Added Successfully";
    }
}
