package com.example.restful.model.mapper;

import com.example.restful.entity.User;
import com.example.restful.model.dto.UserDto;

//chua cac ham convert du lieu tu User sang UserDto, muc dich tai su dung code
public class UserMapper {

  public static UserDto toUserDto(User user) {
    UserDto tmp = new UserDto();
    tmp.setId(user.getId());
    tmp.setName(user.getName());
    tmp.setEmail(user.getEmail());
    tmp.setPhone(user.getPhone());
    tmp.setAvatar(user.getAvatar());

    return tmp;
  }
}
