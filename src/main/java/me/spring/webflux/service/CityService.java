package me.spring.webflux.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CityService {
	Mono<String> getCity(String name);

	Flux<String> findAll(int limit);
}
