package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.AuthorEntryDto;
import com.example.Student_Library_Management_System.Model.Author;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(AuthorEntryDto authorEntryDto){
        //Important Step is : in params : the object is of type
        //DTO but the repository interact only with entity

        //solution : Convert AuthorEntryDto ---> Author
        //created an object of type of Author
        Author author = new Author();

        //we are setting its values so that we can set correct values in DB
        author.setName(authorEntryDto.getName());
        author.setAge(authorEntryDto.getAge());
        author.setCountry(authorEntryDto.getCountry());

        authorRepository.save(author);
        return "Author Added Successfully";
    }
}
