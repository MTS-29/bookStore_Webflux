package com.nisum.webflux;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@SpringBootTest
class WebfluxApplicationTests {

	@Test
	public void   workingWithMono(){
//		// Mono --> 0 or 1 elements
//		Mono<String> errorMono = Mono.error(new RuntimeException("Error!!!!  "));
//		Mono<String> m1 = Mono.just("Learning")
//				.log()
//				.then(errorMono);
//
//
//		// Consume the mono by subscribe
//		m1.subscribe(data ->{
//			System.out.println("Data is :"+ data);
//		});
//
//		errorMono.subscribe(System.out::println);


		Mono<String> m1 = Mono.just("Learning Coding");
		Mono<String> m2 = Mono.just("Subscribe");
		Mono<Integer> m3 = Mono.just(12345);

//		Mono<String> upperCaseM1 = m1.map(item -> item.toUpperCase());
//		upperCaseM1.subscribe(System.out::println);

		Mono<String[]> flatMap = m1.flatMap(item -> Mono.just(item.split(" ")));
		flatMap.subscribe(data ->{
				for (String s : data) {
					System.out.println(s);
				}
		});

//		Mono<Tuple2<String, String>> zipMono = Mono.zip(m1, m2);
//
//		zipMono.subscribe(System.out::println);


	}
}
