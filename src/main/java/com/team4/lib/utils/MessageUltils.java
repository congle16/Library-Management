package com.team4.lib.utils;

import org.springframework.context.MessageSource;


public class MessageUltils {
  
  public static final String ERROR = getMessage("error");
  public static final String ERROR_USER = getMessage("users.exits");
  public static final String ERROR_RE_PASSWORD = getMessage("re.password.not.valid");
  public static final String ERROR_PASSWORD_EMPTY = getMessage("password.not.empty");
  public static final String ERROR_DELETE_CATEGORY = getMessage("delete.category.error");
  public static final String DATE_EXPIRED = getMessage("date.error.expired");
  public static final String DATE_ERROR = getMessage("date.error");
  public static final String BOOK_BORROW_LIMIT = getMessage("book.borrow.limit");
  public static final String BOOK_NOT_ENOUGHT = getMessage("book.not.enought");
  public static final String PASSWORD_NOT_VALID = getMessage("password.not.valid");
  public static final String MAIL_INVALID = getMessage("mail.invalid");

  public static String getMessage(String idmsg) {
    try {
      String msg = BeanUtils.getBean(MessageSource.class).getMessage(idmsg, null, null);
      return msg;
    } catch (Exception e) {
      return idmsg;
    }
  }

}
