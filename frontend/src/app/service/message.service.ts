import { Injectable } from '@angular/core';
import { REST_API_V1_URL } from '../constants';
import { BaseService } from './base.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Message } from '../model/message';
import { CreateMessageDto } from '../model/create-message.dto';

@Injectable()
export class MessageService extends BaseService {
  private baseUrl = `${REST_API_V1_URL}/messages`;

  constructor(private http: HttpClient) {
    super();
  }

  getAllMessages(): Promise<Message[]> {
    return this.http
      .get(this.baseUrl)
      .toPromise()
      .then(response => response as Message[])
      .catch(this.handleError);
  }

  saveMessage(request: CreateMessageDto): Promise<Message> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return this.http
      .post(this.baseUrl, JSON.stringify(request), httpOptions)
      .toPromise()
      .then(response => response as Message)
      .catch(this.handleError);
  }
}
