package com.team4.lib.controller;

import java.text.ParseException;
import java.util.List;
import javax.validation.Valid;

import com.team4.lib.dao.RoleDao;
import com.team4.lib.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.team4.lib.dao.UsersDao;
import com.team4.lib.domain.Users;
import com.team4.lib.utils.StringUtils;

@Controller
@RequestMapping(path = "admin")
@SessionAttributes(names = {"user", "userById"})
public class AdminController {

  @Autowired
  UsersDao usersDao;

  @Autowired
  RoleDao roleDao;

  @GetMapping(path = "/nguoi-dung")
  public String redirectListUser(Model model) {
    List<Users> listUser = usersDao.findAllUser();
    model.addAttribute("listUser", listUser);
    return "/admin/list-user";
  }

  @GetMapping(path = "/thay-doi-thong-tin/{id}")
  public String redirectEditUserPage(@SessionAttribute UserModel user, @PathVariable int id,
                                     Model model) {
    Users userById = usersDao.findUserById(id);

    if (user.getRole() == 2) {
      model.addAttribute("listRole", roleDao.getListRole());
    }

    model.addAttribute("userById", userById);
    return "/admin/edit-user";
  }

  @PostMapping(path = "/thay-doi-thong-tin")
  public String redirectEditUserPage(@SessionAttribute Users userById,
      @SessionAttribute UserModel user, @ModelAttribute("userById") @Valid Users users,
      BindingResult result, Model model) throws ParseException {
    if (result.hasErrors()) {
      return "/admin/edit-user";
    }
    users.setUpdateTime(StringUtils.getTimestampNow());
    users.setUpdateUser(user.getUsername());
    usersDao.editUser(users);
    return "redirect:/admin/nguoi-dung";
  }

}
