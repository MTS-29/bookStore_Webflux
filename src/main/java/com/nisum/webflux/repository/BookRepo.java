package com.nisum.webflux.repository;

import com.nisum.webflux.entites.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface BookRepo extends ReactiveCrudRepository<Book, Integer> {
  Mono<Book> findByName(String name);
  Flux<Book> findByAuthor(String author);
  Flux<Book> findByPublisher(String publisher);
  Flux<Book> findByNameAndAuthor(String name, String author);

  @Query("select * from book_details where name like :title")
  Flux<Book> searchBookByTitle(String title);
}
