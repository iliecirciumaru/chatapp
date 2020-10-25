package com.doodle.challenge.fullstack.chat.service;

import com.doodle.challenge.fullstack.chat.model.CreateMessageRequestDTO;
import com.doodle.challenge.fullstack.chat.model.Message;

import java.util.List;

public interface MessageService {
  List<Message> getMessages();
  Message createMessage(CreateMessageRequestDTO request);
}
