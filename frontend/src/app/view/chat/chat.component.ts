import { Component, OnInit } from '@angular/core';
import { CreateMessageDto } from 'src/app/model/create-message.dto';
import { ErrorResponse } from 'src/app/model/error-response';
import { Message } from 'src/app/model/message';
import { MessageService } from 'src/app/service/message.service';

@Component({
  selector: 'chat',
  templateUrl: './chat.component.html',
})
export class ChatComponent implements OnInit {
  error: ErrorResponse = null;
  messages: Message[] = [];
  loaded = false;

  messageContent: string;

  constructor (private messageService: MessageService) {
  }

  ngOnInit(): void {
    this.getAllMessages();
  }

  getAllMessages() {
    this.messageService.getAllMessages()
      .then(result => {
        this.messages = result;
        this.loaded = true;
      }).catch(error => {
        this.error = new ErrorResponse(error.message || error.statusText || 'An error occurred, please try again', error.code);
        console.log(error);
      });
  }

  sendMessage() {
    const request: CreateMessageDto = new CreateMessageDto(this.messageContent, "Ilie");
    this.messageService.saveMessage(request)
      .then(message => {
        this.messages.push(message);
      }).catch(error => {
        this.error = new ErrorResponse(error.message || error.statusText || 'An error occurred, please try again', error.code);
        console.log(error);
      });
  }
}
