package com.nisum.webflux;

import com.nisum.webflux.service.FluxLearnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
public class FluxLearnTest {

  @Autowired
  FluxLearnService fluxLearnService;


  @Test
  public void fluxCreation(){
    fluxLearnService.getFlux().subscribe(System.out::println);
  }

  @Test
  public void fluxList(){
    fluxLearnService.fruitsFlux().subscribe(System.out::println);
  }

  @Test
  public void emptyFLux(){
    fluxLearnService.getVoidFlux().subscribe(System.out::println);
  }

  @Test
  public void mapFlux(){
    Flux<String> mapFlux = fluxLearnService.mapFlux();
    StepVerifier.create(mapFlux)
        .expectNextCount(5)
        .verifyComplete();
  }

  @Test
  public void filterFlux(){
    Flux<String> filterFlux = fluxLearnService.filterFlux();
    StepVerifier.create(filterFlux)
        .expectNextCount(3)
        .verifyComplete();
  }

  @Test
  public void flatMapFlux(){
//    Flux<String> flatMapFlux = fluxLearnService.flatMapFlux();
//    StepVerifier.create(flatMapFlux)
//        .expectNextCount()
    fluxLearnService.flatMapFlux().subscribe(System.out::println);
  }
 }


