package com.bncc.training2.util;

public class BaseValidator {
  public static boolean isStringValid(String value) {
    return value != null && !value.trim().isEmpty();
  }
}
