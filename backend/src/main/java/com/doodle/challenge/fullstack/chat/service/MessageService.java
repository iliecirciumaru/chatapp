package com.doodle.challenge.fullstack.chat.service;

import com.doodle.challenge.fullstack.chat.model.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {
  List<Message> getMessages();
  Message createMessage(Map<String, String> request);
}
