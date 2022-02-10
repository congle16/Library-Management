package com.team4.lib.service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import com.team4.lib.dao.UsersDao;
import com.team4.lib.domain.Users;
import com.team4.lib.model.UserModel;
import com.team4.lib.model.mapper.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.team4.lib.utils.StringUtils;

@Service
public class UsersServiceImpl implements UsersDao {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<Users> findAllUser() {
    List<Users> listUser = new UserRepository().findAllUser();
    return listUser;
  }

  @Override
  public UserModel findUserByUsername(String username) {
    UserModel userModel = userRepository.findUserByUsername(username);
    return userModel;
  }

  @Override
  public int insertUser(Users users) throws ParseException {
    List<Users> listUser =
        userRepository.findUserByUsernameOrMail(users.getUsername(), users.getMail());
    if (!listUser.isEmpty() || listUser.size() > 0) {
      return 0;
    }
    users.setPassword(passwordEncoder.encode(users.getPassword()));
    users.setCreateUser(users.getUsername());
    users.setUpdateUser(users.getUsername());
    users.setCreateTime(StringUtils.getTimestampNow());
    users.setUpdateTime(StringUtils.getTimestampNow());
    userRepository.insertUser(users);
    return 1;
  }

  @Override
  public void updateUser(Users users) {
    userRepository.updateUser(users);
  }

  @Override
  public Users findUserById(int id) {
    return userRepository.findUserById(id);
  }

  @Override
  public void editUser(Users users) {
    users.setPassword(passwordEncoder.encode(users.getPassword()));
    userRepository.editUser(users);
  }

  @Override
  public void changePasswordUser(Users users) {
    userRepository.changePasswordUser(users);
  }

  @Override
  public List<Users> checkUpdateUser(Users users) {
    return userRepository.checkUpdateUser(users);
  }

  @Override
  public Optional<Users> findUserByMail(String mail) {
    return userRepository.findUserByMail(mail);
  }

  @Override
  public Optional<Users> findUserByToken(String token) {
    return userRepository.findUserByToken(token);
  }

}
