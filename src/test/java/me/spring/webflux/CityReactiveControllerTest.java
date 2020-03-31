package me.spring.webflux;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityReactiveControllerTest {
	@LocalServerPort
	protected int port;

	@Test
	public void testList() throws InterruptedException {
		Flux<String> cities = WebClient.create(String.format("http://127.0.0.1:%d", port))
				.get()
				.uri("/all/50")
				.retrieve()
				.bodyToFlux(String.class);
		cities.take(3).subscribe(System.out::println);
		Thread.sleep(3000);
	}
}
