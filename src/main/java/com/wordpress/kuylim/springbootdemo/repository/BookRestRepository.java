package com.wordpress.kuylim.springbootdemo.repository;

import com.wordpress.kuylim.springbootdemo.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "books", path = "books")
public interface BookRestRepository extends PagingAndSortingRepository<Book,String> {
  @Override
  Page<Book> findAll(Pageable pageable);
}
