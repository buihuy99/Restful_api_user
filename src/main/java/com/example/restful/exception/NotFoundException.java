package com.example.restful.exception;

public class NotFoundException extends RuntimeException{
  public NotFoundException( String message){
    super(message);
  }
}
