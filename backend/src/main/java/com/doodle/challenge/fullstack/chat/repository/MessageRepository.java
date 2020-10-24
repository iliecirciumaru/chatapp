package com.doodle.challenge.fullstack.chat.repository;

import com.doodle.challenge.fullstack.chat.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
