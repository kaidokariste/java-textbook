package com.example.restservice.controller;

import com.example.restservice.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @RestController - Identifies HTTP request component
 * @GetMapping - annotation ensures that HTTP GET requests to /greeting are mapped to the greeting() method.
 * @RequestParam - binds the value of the query string parameter name into the name parameter of the greeting() method
 */


@RestController // Identifies HTTP request component
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
