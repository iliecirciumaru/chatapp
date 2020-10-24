package com.doodle.challenge.fullstack.chat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Entity
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String userName;

  private String content;

  private long createdAt;

  protected Message() {}

  public Message(String userName, String content) {
    this.userName = userName;
    this.content = content;
    this.createdAt = Instant.now().toEpochMilli();
  }

  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getContent() {
    return content;
  }

  public long getCreatedAt() {
    return createdAt;
  }

  @Override
  public String toString() {
    return "Message{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", content='" + content + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}
