package com.example.restful.model.dto;

//Dai dien cho respone tra ve

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
  private int id;
  private String name;
  private String email;
  private String phone;
  private String avatar;
}
