package com.theiconic.spockexamples.common.domain.usecases;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

public class ValidateEmailUseCase implements UseCase<String,Boolean> {
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
      Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

  @Inject
  public ValidateEmailUseCase() {

  }

  @Override
  public Boolean execute(String emailStr) {
    Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
    return matcher.find();
  }
}
