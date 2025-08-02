package com.sprints.library.service;

import com.sprints.library.model.Book;
import com.sprints.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book){
        if(book.getTitle() == null || book.getTitle().trim().isEmpty()){
            throw new IllegalArgumentException("Book Title cannot be empty");
        }
        else if(book.getAuthor() == null || book.getAuthor().trim().isEmpty()){
            throw new IllegalArgumentException("Book author cannot be empty");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book bookDetails){
        Optional<Book> existingBook = bookRepository.findById(id);
        if(existingBook.isPresent()){
            Book book = existingBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            return bookRepository.save(book);
        }
        else{
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    public boolean deleteBook(Long id){
        if(bookRepository.existsById(id)){
            return bookRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Book not found with id: " + id);
        }
    }

    public boolean bookExists(Long id){
        return bookRepository.existsById(id);
    }
}
