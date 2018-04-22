package com.wordpress.kuylim.springbootdemo.services;

import com.wordpress.kuylim.springbootdemo.entity.Book;
import com.wordpress.kuylim.springbootdemo.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BookServices {

  private final BookRepository bookRepository;

  @Inject
  public BookServices(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  public List<Book> getAllBooks(){
    return (List<Book>) bookRepository.findAll();
  }

  public Book getBookById(String id){
    return bookRepository.findOne(id);
  }

  public Book saveBook(Book book){
    bookRepository.save(book);
    return book;
  }
}
