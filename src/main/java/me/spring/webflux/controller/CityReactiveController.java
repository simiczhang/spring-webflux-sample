package me.spring.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.spring.webflux.service.CityService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("")
public class CityReactiveController {
	@Autowired
	private CityService cityService;

	@GetMapping("/one")
	@ResponseBody
	public Mono<String> searchOne() {
		return this.cityService.getCity("Bath");
	}

	@GetMapping("/all/{limit}")
	@ResponseBody
	public Flux<String> list(@PathVariable("limit") int limit) {
		return this.cityService.findAll(limit);
	}

}
