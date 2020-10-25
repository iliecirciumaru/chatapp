package com.doodle.challenge.fullstack.chat.model;

public class CreateMessageRequestDTO {
  private String userName;
  private String content;

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }
}
