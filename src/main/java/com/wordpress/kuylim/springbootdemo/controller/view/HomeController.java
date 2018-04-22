package com.wordpress.kuylim.springbootdemo.controller.view;

import com.wordpress.kuylim.springbootdemo.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Inject;

@Controller
public class HomeController {

  private final BookRepository bookRepository;

  @Inject
  public HomeController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }

  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String index(){

//    bookRepository.save(new Book("1","Spring cook book"));

    return "index";
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  @ResponseBody
  public String home(){
    return "this is home page!!!";
  }
}
