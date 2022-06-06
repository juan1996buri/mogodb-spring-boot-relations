package com.nazeem.spring.mongo.api.service;

import com.nazeem.spring.mongo.api.model.Book;
import com.nazeem.spring.mongo.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public String save(Book book){
        bookRepository.save(book);
        return book.getId();
    }
    public Optional<Book> findById(String id){
        return bookRepository.findById(id);
    }
    public List<Book> findByAuthor(String author){
        Query query  = new Query();
        query.addCriteria(Criteria.where("author").regex(".*"+author+"*.", "i"));

        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }
    public List<Book> findAll(){
        return bookRepository.findAll();
    }
    public void deleteById(String id){
        bookRepository.deleteById(id);
    }
}
