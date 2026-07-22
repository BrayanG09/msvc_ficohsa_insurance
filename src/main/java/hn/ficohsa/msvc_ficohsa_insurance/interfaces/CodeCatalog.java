package hn.ficohsa.msvc_ficohsa_insurance.interfaces;

import org.springframework.http.HttpStatus;

public interface CodeCatalog {
  HttpStatus httpCode();
  String code();
  String message();
  String description();
}
