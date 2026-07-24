package hn.ficohsa.msvc_ficohsa_insurance.enums;

import org.springframework.http.HttpStatus;

import hn.ficohsa.msvc_ficohsa_insurance.interfaces.CodeCatalog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthCodeCatalog implements CodeCatalog {
  INVALID_CREDENTIALS("AUTH_7000", HttpStatus.UNAUTHORIZED, "Usuario y/o contraseña incorrectos",
            "Las credenciales proporcionadas son incorrectas."),
  USER_DISABLED("AUTH_7001", HttpStatus.UNAUTHORIZED, "Usuario y/o contraseña incorrectos",
            "Usuario no authorizado para realizar esta operación."),
  INVALID_TOKEN("AUTH_7002", HttpStatus.UNAUTHORIZED, "No estas autorizado para realizar esta solicitud.",
            "La solicitud requiere autenticación del usuario. El cliente debe proporcionar credenciales válidas para acceder al recurso solicitado."),
  FILTER_AUTH_EXCEPTION("AUTH_7003", HttpStatus.UNAUTHORIZED, "Se produjó un inconveniente al procesar la solicitud, no esta autorizado para realizar esta solicitud.",
            "Se produjó un error no controlado al intentar validar la autorización de la solicitud."),
  ACCOUNT_EXPIRED("AUTH_7004", HttpStatus.UNAUTHORIZED, "No estas autorizado para realizar esta operación.", "Contactá con el equipo de Call Center para recibir ayuda."),
  LOCKED_EXCEPTION("AUTH_7005", HttpStatus.UNAUTHORIZED, "No estas autorizado para realizar esta operación.", "Contactá con el equipo de Call Center para recibir ayuda."),
  DISABLED("AUTH_7006", HttpStatus.UNAUTHORIZED, "No estas autorizado para realizar esta operación.", "Contactá con el equipo de Call Center para recibir ayuda."),
  ;


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
