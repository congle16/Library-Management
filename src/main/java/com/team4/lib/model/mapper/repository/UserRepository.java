package com.team4.lib.model.mapper.repository;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.session.SqlSession;
import com.team4.lib.domain.Users;
import com.team4.lib.model.UserModel;
import com.team4.lib.model.mapper.UserModelMapper;
import com.team4.lib.mybaties.activemodel.Repository;

@org.springframework.stereotype.Repository
public class UserRepository extends Repository<UserModelMapper> {

  @Override
  protected UserModelMapper repositoryMapper(SqlSession session) {
    return session.getMapper(UserModelMapper.class);
  }

  public UserModel findUserByUsername(String username) {
    return execute(mapper -> {
      return mapper.findUserByUsername(username);
    });
  }

  public List<Users> findAllUser() {
    return execute(mapper -> {
      return mapper.findAllUser();
    });
  }

  public List<Users> findUserByUsernameOrMail(String username, String mail) {
    return execute(mapper -> {
      return mapper.findUserByUsernameOrMail(username, mail);
    });
  }

  public int insertUser(Users users) {
    return execute(mapper -> {
      return mapper.insertUser(users);
    });
  }

  public List<Users> checkUpdateUser(Users users) {
    return execute(mapper -> {
      return mapper.checkUpdateUser(users);
    });
  }

  public void updateUser(Users users) {
    execute(mapper -> {
      mapper.updateUser(users);
    });
  }

  public Users findUserById(int id) {
    return execute(mapper -> {
      return mapper.findUserById(id);
    });
  }

  public void editUser(Users users) {
    execute(mapper -> {
      mapper.editUser(users);
    });
  }

  public void changePasswordUser(Users users) {
    execute(mapper -> {
      mapper.changePasswordUser(users);
    });
  }

  public Optional<Users> findUserByMail(String mail) {
    return execute(mapper -> {
      return mapper.findUserByMail(mail);
    });
  }

  public Optional<Users> findUserByToken(String token) {
    return execute(mapper -> {
      return mapper.findUserByToken(token);
    });
  }

}
