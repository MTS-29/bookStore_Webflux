package com.nisum.webflux.controller;

import com.nisum.webflux.entites.Book;
import com.nisum.webflux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;
  @PostMapping
  public Mono<Book> createBook(@RequestBody Book book){
    return bookService.create(book);
  }

  @GetMapping
  public Flux<Book> getAll(){
    return bookService.getAll();
  }

  @GetMapping("/{bookId}")
  public Mono<Book> getBookById(@PathVariable int bookId){
    return bookService.get(bookId);
  }

  @PutMapping("/{bookId}")
  public Mono<Book> updateBook(@RequestBody Book book, @PathVariable int bookId){
    return bookService.update(book, bookId);
  }

  @DeleteMapping("/{bookId}")
  public Mono<Void> deleteBook(@PathVariable int bookId){
    return bookService.delete(bookId);
  }

  @GetMapping("/search/{title}")
  public Flux<Book> searchBooks(@PathVariable String title){
    return bookService.searchBookByTile(title);
  }
}
