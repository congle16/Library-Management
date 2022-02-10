package com.team4.lib.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.team4.lib.model.UserModel;

public class BaseService {

  public UserModel getSession(HttpServletRequest request) {
    HttpSession session = (HttpSession) request.getSession();
    UserModel user = (UserModel) session.getAttribute("user");
    return user;
  }

  public void setCreateFiled(Object obj, HttpServletRequest request) {

  }
}
