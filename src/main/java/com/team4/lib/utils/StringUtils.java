package com.team4.lib.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

  private static final String EMAIL_REGEX =
      "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";
  private static final String PHONE_REGEX = "(09|01[2|6|8|9])+([0-9]{8})\\b";
  private static final String ALPHA_NUMERIC_STRING =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
  private static Pattern pattern;
  private static Matcher matcher;

  public static boolean validateEmail(String email) {
    pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    matcher = pattern.matcher(email);
    return matcher.matches();
  }

  public static boolean isNumeric(String strNum) {
    return strNum.matches("-?\\d+(\\.\\d+)?");
  }

  public static boolean isPhone(String strNum) {
    return strNum.matches(PHONE_REGEX);
  }

  public static Timestamp getTimestampNow() throws ParseException {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String formatDateTime = now.format(formatter);
    Timestamp ts = Timestamp.valueOf(formatDateTime);
    return ts;
  }

  public static long daysBetween2Dates(Date dateBegin, Date dateEnd) {
    long diff = dateEnd.getTime() - dateBegin.getTime();
    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
  }

  public static String generateRandomPassword(int lenght) {
    StringBuilder sb = new StringBuilder(lenght);
    for (int i = 0; i < lenght; i++) {
      int index = (int) (ALPHA_NUMERIC_STRING.length() * Math.random());

      sb.append(ALPHA_NUMERIC_STRING.charAt(index));
    }

    return sb.toString();
  }

}
