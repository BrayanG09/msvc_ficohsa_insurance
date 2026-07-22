package hn.ficohsa.msvc_ficohsa_insurance.enums;

import org.springframework.http.HttpStatus;

import hn.ficohsa.msvc_ficohsa_insurance.interfaces.CodeCatalog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InsuranceCodeCatalog implements CodeCatalog {
  FIND_ALL_INSURANCE_EXCEPTION("IS_8000", HttpStatus.INTERNAL_SERVER_ERROR, "Se produjó un inconveniente al obtener los seguros.",
            "Se produjó un error interno al listar los seguros/productos.");


  private final String code;
  private final HttpStatus httpCode;
  private final String message;
  private final String description;

  @Override
  public String code() {
    return code;
  }

  @Override
  public String message() {
    return message;
  }

  @Override
  public String description() {
    return description;
  }

  @Override
  public HttpStatus httpCode() {
    return httpCode;
  }
}
