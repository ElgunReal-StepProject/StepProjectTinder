package entity;

import java.time.LocalDateTime;

public class Message {
  User from;
  User to;
  String text;
  LocalDateTime sentTime;

  public Message(User from, User to, String text, LocalDateTime sentTime) {
    this.from = from;
    this.to = to;
    this.text = text;
    this.sentTime = sentTime;
  }
}
