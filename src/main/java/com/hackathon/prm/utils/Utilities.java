package com.hackathon.prm.utils;

import com.google.common.collect.ImmutableSet;

import java.util.Set;

public class Utilities {

  //  private static final Set<String> regexSpclChars =
  //      ImmutableSet.of(
  //          "\\", "^", "$", ".", "|", "?", "*", "+", "(", ")", "[", "]", "{", "}", "-", "¡", "™",
  // "£",
  //          "¢", "¢", "§", "¶", "•", "ª", "€", "‹", "›", "ﬁ", "°", "฿");

  private static final Set<String> regexSpclChars =
      ImmutableSet.of("\\", "^", "$", ".", "|", "?", "*", "+", "(", ")", "[", "]", "{", "}", "-");

  public static String formatForRegex(String rawString, boolean includeWildcard) {
    String result = includeWildcard ? "*" : "";

    for (int i = 0; i < rawString.length(); i++) {
      // if (rawString.substring(i, i + 1).matches("[^A-Za-z0-9]")) {
      if (regexSpclChars.contains(rawString.substring(i, i + 1))) {
        result = result + "\\" + rawString.substring(i, i + 1);
      } else {
        result += rawString.substring(i, i + 1);
      }
    }
    result = includeWildcard ? result + "*" : result;
    return result;
  }
}
