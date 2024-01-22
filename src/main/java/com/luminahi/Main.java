package com.luminahi;

import java.util.List;

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
        return new GreetResponse(
                "hello",
                List.of("TypeScript", "C", "Csharp", "Java"),
                new Person("alex", 20, "programmer")
        );
    }
    
    @GetMapping("/")
    public Person InTheRoot() {
        return new Person("alex", 20, "programmer");
    }
    
    record GreetResponse(
            String greet,
            List<String> favoriteProgrammingLanguages,
            Person person
        ) {}
    
    record Person(String name, int age, String profession) {}
}
