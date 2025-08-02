package com.sprints.library.repository;

import com.sprints.library.model.Book;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    private List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> findAll() {
        return new ArrayList<>(books);
    }

    public Optional<Book> findById(Long id){
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book save(Book book) {
        if(book.getId() == null){
            book.setId(nextId++);
        }
        else{
            deleteById(book.getId());
        }
        books.add(book);
        return book;
    }

    public boolean deleteById(Long id){
        return books.removeIf(book -> book.getId().equals(id));
    }

    public boolean existsById(Long id){
        return books.stream().anyMatch(book -> book.getId().equals(id));
    }
}
