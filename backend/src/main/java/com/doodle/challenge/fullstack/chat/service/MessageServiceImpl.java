package com.doodle.challenge.fullstack.chat.service;

import com.doodle.challenge.fullstack.chat.model.CreateMessageRequestDTO;
import com.doodle.challenge.fullstack.chat.model.Message;
import com.doodle.challenge.fullstack.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
  private final MessageRepository messageRepository;

  @Autowired
  public MessageServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public List<Message> getMessages() {
    return this.messageRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
  }

  @Override
  public Message createMessage(CreateMessageRequestDTO request) {
    Message message = new Message(request.getUserName(), request.getContent());
    return this.messageRepository.save(message);
  }
}
