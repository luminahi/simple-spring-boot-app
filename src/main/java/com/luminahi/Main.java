package com.luminahi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
    
    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse("hello");
    }
    
    @GetMapping("/")
    public Person InTheRoot() {
        return new Person("alex", 20, "programmer");
    }
    
    record GreetResponse(String greet) {}
    record Person(String name, int age, String profession) {}
}
