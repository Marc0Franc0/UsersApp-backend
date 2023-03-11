package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import com.app.model.UserResponse;
import com.app.security.user.User;
import com.app.security.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  UserRepository repository;

  @Override
  public List<UserResponse> getUsers() {

    List<UserResponse> list = new ArrayList<>();
    for (int i = 0; i < repository.findAll().size(); i++) {
      UserResponse response = new UserResponse();
      response.setId(repository.findAll().get(i).getId());
      response.setFirstname(repository.findAll().get(i).getFirstname());
      response.setEmail(repository.findAll().get(i).getEmail());
      response.setLastname(repository.findAll().get(i).getLastname());
      list.add(response);
    }
    return list;
  }

  @Override
  public String modifyUser(Integer id, User user) {
    User userAlmacenado = repository.findById(id).get();
    userAlmacenado.setId(id);
    userAlmacenado.setFirstname(user.getFirstname());
    userAlmacenado.setLastname(user.getLastname());
    userAlmacenado.setEmail(user.getEmail());

    repository.save(userAlmacenado);
    return "Usuario modificado";
  }

  @Override
  public boolean isAdmin(String email) {
    String rol = repository.findByEmail(email).get().getAuthorities().toString();
    if (rol.equals("[ADMIN]")) {
      return true;
    } else {
      return false;
    }

  }
}