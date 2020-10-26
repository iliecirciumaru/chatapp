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
			repository.save(new Message("Ilie", "Hello, Doodler!"));
			repository.save(new Message("Doodle", "Hey, Ilie"));
		};
	}

}
