export class CreateMessageDto {
  constructor(content: string, userName: string) {
    this.content = content;
    this.userName = userName;
  }
  content: string;
  userName: string;
}
