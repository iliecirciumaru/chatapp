package com.doodle.challenge.fullstack.chat.repository;

import com.doodle.challenge.fullstack.chat.model.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
  @Query(value = "SELECT m FROM Message m")
  List<Message> findAll(Sort sort);
}
