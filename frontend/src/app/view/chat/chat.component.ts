import { Component, ElementRef, OnInit, ViewChild, ViewContainerRef } from '@angular/core';
import { CreateMessageDto } from 'src/app/model/create-message.dto';
import { ErrorResponse } from 'src/app/model/error-response';
import { Message } from 'src/app/model/message';
import { MessageService } from 'src/app/service/message.service';
import { REST_API_URL } from '../../constants';
import * as sockjs from 'sockjs-client';
import * as stomp from '@stomp/stompjs';
import { CompatClient, Client } from '@stomp/stompjs';

@Component({
  selector: 'chat',
  templateUrl: './chat.component.html',
})
export class ChatComponent implements OnInit {
  socket:any;
  stompClient: CompatClient;

  @ViewChild('chatHistory', {static: false}) 
  chatHistoryContainer: ElementRef;
  
  error: ErrorResponse = null;
  messages: Message[] = [];
  loaded = false;

  messageContent: string;
  user: string;

  constructor (private messageService: MessageService) {
  }

  setupSocketConnection() {
    this.socket = new sockjs(REST_API_URL + "/gs-guide-websocket");
    this.stompClient = stomp.Stomp.over(this.socket);
    this.stompClient.connect({}, frame => {
      this.stompClient.subscribe("/topic/chat-messages", message => {
        this.messages.push(JSON.parse(message.body) as Message);
        this.scrollToBottom();
      });
    });
  }

  ngOnInit(): void {
    this.getAllMessages();
    this.setupSocketConnection();
  }

  scrollToBottom() {
    setTimeout(() => {
      this.chatHistoryContainer.nativeElement.scrollTop = this.chatHistoryContainer.nativeElement.scrollHeight;
    }, 200);
  }

  getAllMessages() {
    this.messageService.getAllMessages()
      .then(result => {
        this.messages = result;
        this.loaded = true;
        this.scrollToBottom();
      }).catch(error => {
        this.error = new ErrorResponse(error.message || error.statusText || 'An error occurred, please try again', error.code);
        console.log(error);
      });
  }

  sendMessage() {
    const request: CreateMessageDto = new CreateMessageDto(this.messageContent, this.user);
    this.stompClient.send("/app/post-message", {}, JSON.stringify(request));
    this.messageContent = '';
  }
}
