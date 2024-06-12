package com.eco2mix.error;

import java.util.Date;

public class ErrorDetails {
  private Date date;
  private int statusCode;
  private String message;

  public ErrorDetails(Date date, int statusCode, String message) {
    this.date = date;
    this.statusCode = statusCode;
    this.message = message;
  }

  public Date getdate() {
    return date;
  }

  public void setdate(Date date) {
    this.date = date;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

}
