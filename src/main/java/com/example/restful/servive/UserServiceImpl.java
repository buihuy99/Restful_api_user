package com.example.restful.servive;


import com.example.restful.entity.User;
import com.example.restful.exception.NotFoundException;
import com.example.restful.model.dto.UserDto;
import com.example.restful.model.mapper.UserMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

  // tạo 1 mảng user động thay cho DB
  public static ArrayList<User> users = new ArrayList<User>();

  static {
    users.add(new User(1, "Nguyen Van A", "a@gmail.com", "0101010101", "a_avatar.img", "a111111"));
    users.add(new User(2, "Nguyen Van B", "b@gmail.com", "0202020220", "b_avatar.img", "b111111"));
    users.add(new User(3, "Nguyen Van C", "c@gmail.com", "0303030303", "c_avatar.img", "c111111"));
    users.add(new User(4, "Nguyen Van D", "d@gmail.com", "0444444444", "d_avatar.img", "d111111"));
    users.add(new User(5, "Nguyen Van E", "e@gmail.com", "0555555555", "e_avatar.img", "e111111"));
    users.add(new User(6, "Nguyen Van F", "f@gmail.com", "0666666666", "f_avatar.img", "f111111"));
    users.add(new User(7, "Nguyen Van G", "g@gmail.com", "0777777777", "g_avatar.img", "g111111"));

  }

  @Override
  public List<UserDto> getListUser() {
    List<UserDto> result = new ArrayList<UserDto>();
    for (User user : users) {
      result.add(UserMapper.toUserDto(user));
    }
    return result;
  }

  @Override
  public UserDto getUserById(int id) {
    for (User user : users) {
      if (user.getId() == id) {
        return UserMapper.toUserDto(user);
      }
    }

    throw new NotFoundException("User not found");
  }

  @Override
  public List<UserDto> searchUser(String keyword) {
    List<UserDto> result = new ArrayList<UserDto>();
    for (User user : users) {
      if (user.getName().contains(keyword)) {
        result.add(UserMapper.toUserDto(user));
      }
    }
    return result;
  }

  @Override
  public User createUser(User user) {
    users.add(user);
    return user;
  }

  @Override
  public boolean checkUserExists(String email) {
    return true;
  }

  @Override
  public UserDto updateUser(int id) {
    for (User user : users) {
      if (user.getId() == id) {
        return UserMapper.toUserDto(user);
      }
    }

    throw new NotFoundException("User not found");
  }

  @Override
  public UserDto deleteUser(int id) {
    for (User user : users) {
      if (user.getId() == id) {
        int valueToRemove = id;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
          User userDelete = iterator.next();
          if (userDelete.getId() == valueToRemove) {
            iterator.remove();
          }
        }
        return UserMapper.toUserDto(user);
      }
    }
    throw new NotFoundException("User not found");
  }
}
