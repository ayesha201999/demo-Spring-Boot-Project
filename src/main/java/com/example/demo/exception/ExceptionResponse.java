package com.example.demo.exception;
import java.util.Date;

public class ExceptionResponse {
  private Date timestamp;
  private String message;
  private String details;

  public ExceptionResponse(Date timestamp, String message) {
    super();
    this.timestamp = timestamp;
    this.message = message;
  }

  public Date getTimestamp() {
    return timestamp;
  }

  public String getMessage() {
    return message;
  }


}