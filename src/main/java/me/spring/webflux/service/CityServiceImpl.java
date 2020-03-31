package me.spring.webflux.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Component
class CityServiceImpl implements CityService {

	private List<String> allCities;

	public CityServiceImpl() {
		allCities = new ArrayList<>();
		for(int i = 0; i < 10000; i++) {
			allCities.add(RandomStringUtils.randomAlphabetic(12));
		}
	}

	@Override
	public Mono<String> getCity(String name) {
		return Mono.just(name);
	}

	@Override
	public Flux<String> findAll(int limit) {
		return Flux.fromIterable(allCities).log().take(limit);
	}
}