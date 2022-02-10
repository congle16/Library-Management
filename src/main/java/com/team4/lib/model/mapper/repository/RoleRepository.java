package com.team4.lib.model.mapper.repository;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.team4.lib.domain.Role;
import com.team4.lib.model.mapper.RoleModelMapper;
import com.team4.lib.mybaties.activemodel.Repository;

public class RoleRepository extends Repository<RoleModelMapper> {

  @Override
  protected RoleModelMapper repositoryMapper(SqlSession session) {
    return session.getMapper(RoleModelMapper.class);
  }

  public List<Role> getListRole() {
    return execute(mapper -> {
      return mapper.getListRole();
    });
  }

}
