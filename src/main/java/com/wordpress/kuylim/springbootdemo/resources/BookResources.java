package com.wordpress.kuylim.springbootdemo.resources;

import com.wordpress.kuylim.springbootdemo.entity.Book;
import com.wordpress.kuylim.springbootdemo.services.BookServices;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Component
@Path("/books")
public class BookResources {
  private final BookServices bookService;

  @Inject
  public BookResources(BookServices bookService) {
    this.bookService = bookService;
  }

  @GET
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllBooks(){
    return Response.ok(bookService.getAllBooks()).build();
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getBookById(@PathParam("id") String id){
    return Response.ok(bookService.getBookById(id)).build();
  }

  @POST
  @Path("")
  @Consumes(MediaType.APPLICATION_JSON)
  public Response saveNewBook(Book book){
    bookService.saveBook(book);
    return Response.status(200).build();
  }
}
