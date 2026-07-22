package hn.ficohsa.msvc_ficohsa_insurance.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class RegexConstants {
  public static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{6,}$";
}
