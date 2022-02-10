package com.team4.lib.custom.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.team4.lib.custom.annotation.Phone;
import com.team4.lib.utils.StringUtils;

public class PhoneConstraintValidator implements ConstraintValidator<Phone, String> {

  @Override
  public boolean isValid(String phoneField, ConstraintValidatorContext context) {
    if (phoneField == null) {
      return false;
    }
    return StringUtils.isPhone(phoneField);
  }

}
