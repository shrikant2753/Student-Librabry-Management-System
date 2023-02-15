package com.example.Student_Library_Management_System.Service;

import com.example.Student_Library_Management_System.DTOs.BookRequestDto;
import com.example.Student_Library_Management_System.Model.Author;
import com.example.Student_Library_Management_System.Model.Book;
import com.example.Student_Library_Management_System.Repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(BookRequestDto bookRequestDto){
        //getting author id
        int authorId = bookRequestDto.getAuthorId();

        //Fetching the author entity from db
        Author author = authorRepository.findById(authorId).get();
        //add exceptional handling if author is not present

        //creating new book attribute
        Book book = new Book();
        //Setting the DTO to Entity
        book.setName(bookRequestDto.getName());
        book.setPages(bookRequestDto.getPages());
        book.setGenre(bookRequestDto.getGenre());
        book.setIssued(false);
        //setting the foreign key attributes in child class
        book.setAuthor(author);

        //we need to update a written books in parent class i.e. Author

        List<Book>currWrittenBook = author.getBooksWritten();
        currWrittenBook.add(book);
        author.setBooksWritten(currWrittenBook);

        //Book is saved, but we have to update an author also
        //Why we need to save(an update) author again?
        //bcz...author entity has been updated, so we need to update it.

        authorRepository.save(author);//updating
        //bookRepo.save is not required: bcz it will be autoCalled by cascading effect
        return "Book added successfully";
    }
}
