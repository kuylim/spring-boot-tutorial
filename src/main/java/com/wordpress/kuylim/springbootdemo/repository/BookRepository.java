package com.wordpress.kuylim.springbootdemo.repository;

import com.wordpress.kuylim.springbootdemo.entity.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {
}
