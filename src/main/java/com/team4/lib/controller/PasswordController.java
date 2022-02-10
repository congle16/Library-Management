package com.team4.lib.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;

import com.team4.lib.dao.EmailDao;
import com.team4.lib.dao.UsersDao;
import com.team4.lib.domain.Users;
import com.team4.lib.model.MailDto;
import com.team4.lib.utils.MessageUltils;
import com.team4.lib.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/forgot")
public class PasswordController {

  @Autowired
  UsersDao usersDao;

  @Autowired
  EmailDao emailDao;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping
  public String displayForgotPasswordPage() {
    return "forgot-password";
  }

  @PostMapping
  public String processForgotPasswordForm(Model model, @RequestParam("mail") String mail,
      HttpServletRequest request) throws ParseException {

    Optional<Users> optional = usersDao.findUserByMail(mail);

    if (optional.isPresent()) {
      Users user = optional.get();
      user.setToken(UUID.randomUUID().toString());
      usersDao.updateUser(user);

      String appUrl =
          request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

      MailDto mailDto = new MailDto();
      mailDto.setMailFrom("admin@gmail.com");
      mailDto.setMailTo(mail);
      mailDto.setMailSubject("Reset Password");

      Map<String, Object> modelMap = new HashMap<String, Object>();
      modelMap.put("name", user.getUsername());
      modelMap.put("create", StringUtils.getTimestampNow());
      modelMap.put("location", "Admin");
      modelMap.put("signature", appUrl + "/forgot/reset?token=" + user.getToken());
      mailDto.setModel(modelMap);

      emailDao.sendEmail(mailDto);
    }

    model.addAttribute("successMessage", "Link đặt lại mật khẩu đã được gửi tới email " + mail);

    return "forgot-password";

  }

  @GetMapping("/reset")
  public String displayResetPasswordPage(Model model, @RequestParam("token") String token) {

    Optional<Users> user = usersDao.findUserByToken(token);

    if (user.isPresent()) {
      model.addAttribute("token", token);
    } else {
      model.addAttribute("errorMessage", "Lỗi! Link reset mật khẩu không đúng.");
      return "403";
    }

    return "reset-password";
  }

  @PostMapping("/reset")
  public String setNewPassword(Model model, @RequestParam String token,
      @RequestParam String passwordNew, @RequestParam("rePassword") String rePassword,
      RedirectAttributes redir) {

    Optional<Users> user = usersDao.findUserByToken(token);

    if (!passwordNew.equals(rePassword)) {
      model.addAttribute("errorMessage", MessageUltils.ERROR_RE_PASSWORD);
      return "reset-password";
    }

    if (passwordNew == null || rePassword == null) {
      model.addAttribute("errorMessage", MessageUltils.ERROR_PASSWORD_EMPTY);
      return "reset-password";
    } else {
      if (user.isPresent()) {

        Users resetUser = user.get();

        resetUser.setPassword(passwordEncoder.encode(passwordNew));

        resetUser.setToken(null);

        usersDao.changePasswordUser(resetUser);

        usersDao.updateUser(resetUser);

        return "redirect:/login";

      } else {
        model.addAttribute("errorMessage", MessageUltils.ERROR);
      }
    }
    return "reset-password";
  }

}
