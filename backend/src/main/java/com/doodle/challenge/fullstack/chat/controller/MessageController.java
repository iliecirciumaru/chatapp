package com.doodle.challenge.fullstack.chat.controller;

import com.doodle.challenge.fullstack.chat.model.Message;
import com.doodle.challenge.fullstack.chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
  public Message createMessage(@RequestBody Map<String, String> request) {
    return this.messageService.createMessage(request);
  }

}
