package com.wordpress.kuylim.springbootdemo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Book {
  @Id
  @ApiModelProperty(hidden = true)
  String id;

  String name;

  String author;

  public Book(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Book() {
  }
}
