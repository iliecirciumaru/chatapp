package com.doodle.challenge.fullstack.chat;

import com.doodle.challenge.fullstack.chat.model.Message;
import com.doodle.challenge.fullstack.chat.repository.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class ChatApplication {
	private static final Logger log = LoggerFactory.getLogger(ChatApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(MessageRepository repository) {
		return (args) -> {
			// save a few customers
			repository.save(new Message("Jack", "Hello world"));
			repository.save(new Message("Ilie", "Hi, Jack"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Message customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Optional<Message> byId = repository.findById(1L);
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(byId.get().toString());
			log.info("");

		};
	}

}
