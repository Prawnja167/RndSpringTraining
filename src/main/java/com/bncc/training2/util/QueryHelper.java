package com.bncc.training2.util;

public class QueryHelper {
  private static final String SQL_ZERO_OR_MORE = "%";

  public static String likeAfter(String value) {
    if (BaseValidator.isStringValid(value)) {
      value = value.trim() + SQL_ZERO_OR_MORE;
    } else {
      value = SQL_ZERO_OR_MORE;
    }

    return value;
  }
}
