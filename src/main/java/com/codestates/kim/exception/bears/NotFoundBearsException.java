package com.codestates.kim.exception.bears;

public class NotFoundBearsException extends RuntimeException {
  public NotFoundBearsException(String message) { super(message); }
    public NotFoundBearsException() { this("곰을 찾을 수 없습니다."); }
}
