
package com.team4.lib.service;

import java.util.HashSet;
import java.util.Set;

import com.team4.lib.model.UserModel;
import com.team4.lib.model.mapper.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);


  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    UserModel userModel = new UserRepository().findUserByUsername(username);
    if (userModel == null) {
      throw new UsernameNotFoundException("User not found");
    }
    // userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
    Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
    String rolesName = userModel.getRoleName();
    grantedAuthorities.add(new SimpleGrantedAuthority(rolesName));

    return new org.springframework.security.core.userdetails.User(userModel.getUsername(),
        userModel.getPassword(), grantedAuthorities);
  }



}
