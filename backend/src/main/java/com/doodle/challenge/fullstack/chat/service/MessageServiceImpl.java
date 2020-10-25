package com.doodle.challenge.fullstack.chat.service;

import com.doodle.challenge.fullstack.chat.model.CreateMessageRequestDTO;
import com.doodle.challenge.fullstack.chat.model.Message;
import com.doodle.challenge.fullstack.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {
  private final MessageRepository messageRepository;

  @Autowired
  public MessageServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public List<Message> getMessages() {
    List<Message> messages = new LinkedList<>();
    this.messageRepository.findAll()
                          .iterator()
                          .forEachRemaining(messages::add);

    return messages;
  }

  @Override
  public Message createMessage(CreateMessageRequestDTO request) {
    Message message = new Message(request.getUserName(), request.getContent());
    return this.messageRepository.save(message);
  }
}
