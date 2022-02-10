package com.team4.lib.model.mapper;

import java.util.List;
import java.util.Optional;
import com.team4.lib.domain.Users;
import com.team4.lib.model.UserModel;

public interface UserModelMapper {

  List<Users> findAllUser();

  UserModel findUserByUsername(String username);

  int insertUser(Users users);

  List<Users> findUserByUsernameOrMail(String username, String mail);

  List<Users> checkUpdateUser(Users users);

  void updateUser(Users users);

  Users findUserById(int id);

  void editUser(Users users);

  void changePasswordUser(Users users);

  Optional<Users> findUserByMail(String mail);

  Optional<Users> findUserByToken(String token);
}
