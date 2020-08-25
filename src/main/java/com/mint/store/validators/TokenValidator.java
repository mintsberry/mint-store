package com.mint.store.validators;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author MintsBerry
 * @date 2020/8/24
 */
public class TokenValidator implements ConstraintValidator<TokenPassword, String> {
  private TokenPassword tokenPassword;
  @Override
  public void initialize(TokenPassword constraintAnnotation) {
    this.tokenPassword = constraintAnnotation;
  }

  @Override
  public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
    if(StringUtils.isEmpty(s)) {
      return true;
    }
    return s.length() > tokenPassword.min() && s.length() < tokenPassword.max();
  }
}
