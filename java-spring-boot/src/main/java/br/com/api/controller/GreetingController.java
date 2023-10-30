package br.com.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping
	public ResponseEntity<Greeting> teste(@RequestParam(value = "name", defaultValue = "World") String name) {
		Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
		return ResponseEntity.ok(greeting);
	}

}
