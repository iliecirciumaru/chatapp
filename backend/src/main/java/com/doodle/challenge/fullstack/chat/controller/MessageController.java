package com.doodle.challenge.fullstack.chat.controller;

import com.doodle.challenge.fullstack.chat.model.CreateMessageRequestDTO;
import com.doodle.challenge.fullstack.chat.model.Message;
import com.doodle.challenge.fullstack.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "${v1Api}")
public class MessageController {
  private final MessageService messageService;

  @Autowired
  public MessageController(MessageService messageService) {
    this.messageService = messageService;
  }

  @GetMapping(path = "/messages", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Message> getMessages() {
    return this.messageService.getMessages();
  }

  @PostMapping(path = "/messages")
  @MessageMapping("/post-message")
  @SendTo("/topic/chat-messages")
  public Message createMessage(@RequestBody CreateMessageRequestDTO request) {
    if (request.getUserName() == null || request.getUserName().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is empty");
    }
    if (request.getContent() == null || request.getContent().isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username is empty");
    }
    return this.messageService.createMessage(request);
  }
}
