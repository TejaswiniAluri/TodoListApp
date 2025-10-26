package tejaswini.in.todolistapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistappApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistappApplication.class, args);
	}

}

//http://localhost:8080/todos - accessing teh web page without postman

//http://localhost:8080/h2-console - for in memory

//JDBC URL: jdbc:h2:file:./data/todolistapp


