package com.nisum.webflux.service;

import java.util.List;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class FluxLearnService {
  
  public Flux<String> getFlux(){
    return Flux.just("Ankit","Dev","Taqui","Rahul","Ram");
  }

  public Flux<String> fruitsFlux(){
    List<String> fruitsName = List.of("Mango", "Apple", "Banana");
    return Flux.fromIterable(fruitsName).log();
  }

  public Flux<Void> getVoidFlux(){
    return Flux.empty();
  }
  
  //Map 
  public Flux<String> mapFlux(){
    Flux<String> upperMap = getFlux().map(String::toUpperCase);
    return upperMap;
  }

  public Flux<String> filterFlux(){
    Flux<String> filterFlux = getFlux().filter(data -> data.length() >= 4).log();
    return filterFlux;
  }

  public  Flux<String> flatMapFlux(){
    return getFlux().flatMap(item -> Flux.just(item.split("")));
  }
}
