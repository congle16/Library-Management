package com.team4.lib.service;

import java.util.List;

import com.team4.lib.dao.RoleDao;
import com.team4.lib.domain.Role;
import com.team4.lib.model.mapper.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleDao {

  @Override
  public List<Role> getListRole() {
    return new RoleRepository().getListRole();
  }

}
