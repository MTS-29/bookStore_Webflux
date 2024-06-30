package com.nisum.webflux.service.implementation;

import com.nisum.webflux.entites.Book;
import com.nisum.webflux.repository.BookRepo;
import com.nisum.webflux.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

  @Autowired
  private BookRepo bookRepo;
  @Override
  public Mono<Book> create(Book book) {
    Mono<Book> createdBook = bookRepo.save(book);
    return createdBook;
  }

  @Override
  public Flux<Book> getAll() {
    Flux<Book> allBooks = bookRepo.findAll();
    return allBooks;
  }

  @Override
  public Mono<Book> get(int bookId) {
    Mono<Book> singleBook = bookRepo.findById(Mono.just(bookId));
    return singleBook;
  }

  @Override
  public Mono<Book> update(Book book, int bookId) {
    Mono<Book> oldBook = bookRepo.findById(bookId);
     return oldBook.flatMap(item ->{
       item.setAuthor(book.getAuthor());
       item.setDescription((book.getDescription()));
       item.setName(book.getName());
       item.setPublisher(book.getPublisher());
       return bookRepo.save(item);
     });
  }

  @Override
  public Mono<Void> delete(int bookId) {
    Mono<Void> deleteBookById = bookRepo.findById(bookId)
        .flatMap(item -> bookRepo.delete(item));
    return deleteBookById;
  }

  @Override
  public Flux<Book> search(String query) {
    return null;
  }

  @Override
  public Flux<Book> searchBookByTile(String title) {
    return bookRepo.searchBookByTitle("%"+title+"%");
  }
}
