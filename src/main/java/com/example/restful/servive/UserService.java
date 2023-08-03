package com.example.restful.servive;

import com.example.restful.entity.User;
import com.example.restful.model.dto.UserDto;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
  public List<UserDto> getListUser();
  public UserDto getUserById(int id);
  public List<UserDto> searchUser(String keyword);
  public User createUser(User user);
  public boolean checkUserExists(String email);
  public UserDto updateUser(int id);
  public UserDto deleteUser(int id);

}
