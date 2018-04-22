package com.wordpress.kuylim.springbootdemo.controller.api;

import com.wordpress.kuylim.springbootdemo.entity.Book;
import com.wordpress.kuylim.springbootdemo.services.BookServices;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/books")
public class BookController {

  private final BookServices bookServices;

  @Inject
  public BookController(BookServices bookServices) {
    this.bookServices = bookServices;
  }

  @GetMapping
  @ApiOperation(value = "View a list of available books", response = Map.class)
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Successfully get list of books"),
    @ApiResponse(code = 401, message = "You are not authorized to view this resources."),
    @ApiResponse(code = 403, message = "Accessing resource you trying to reach is forbidden"),
    @ApiResponse(code = 404, message = "This resource not found")
  })
  public ResponseEntity<Map<String, Object>> getAllBooks() {
    Map<String, Object> map = new HashMap<>();
    List<Book> books = bookServices.getAllBooks();

    try {
      if (!books.isEmpty()) {
        map.put("data", books);
        map.put("status", 200);
        map.put("message", "list of books");
      } else {
        map.put("status", 404);
        map.put("message", "books not found!!");
      }
    } catch (Exception ex) {
      map.put("status", 500);
      map.put("message", "internal server error!!");
    }

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Map<String, Object>> getBookById(@PathVariable("id") String id) {
    Map<String, Object> map = new HashMap<>();
    Book book = bookServices.getBookById(id);

    try {
      if (book != null) {
        map.put("data", book);
        map.put("status", 200);
        map.put("message", "Book found");
      } else {
        map.put("status", 404);
        map.put("message", "Book not found!!");
      }
    } catch (Exception ex) {
      map.put("status", 500);
      map.put("message", "internal server error!!");
    }

    return new ResponseEntity<>(map, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Map<String, Object>> saveBook(@RequestBody Book newBook) {
    Map<String, Object> map = new HashMap<>();
    Book book = bookServices.saveBook(newBook);

    try {
      if (book != null){
        map.put("data", book);
        map.put("status", 200);
        map.put("message", "Book save success!!");
      }
      else{
        map.put("status", 400);
        map.put("message", "Book cannot save!!");
      }
    } catch (Exception ex) {
      map.put("status", 500);
      map.put("message", "internal server error!!");
    }

    return new ResponseEntity<>(map, HttpStatus.OK);
  }
}
