package com.sample.rest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/")
    public void homeInit() {
        System.out.println("dsc");
    }

    @PostMapping("/log")
    public void newEmployee(@RequestBody String log) {
        System.out.println("log "+ log);
    }
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("name is "+name);
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
