package hn.ficohsa.msvc_ficohsa_insurance.enums;

import org.springframework.http.HttpStatus;

import hn.ficohsa.msvc_ficohsa_insurance.interfaces.CodeCatalog;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum QuotationCodeCatalog implements CodeCatalog {
  USERNAME_NOT_FOUND("Q_9000", HttpStatus.NOT_FOUND, "No existe un usuario asociado al identificador proporcionado.",
      "Asegúrate que el usuario sea el correcto."),
  INSURANCE_NOT_FOUND("Q_9001", HttpStatus.NOT_FOUND, "No existe un seguro asociado al identificador proporcionado.",
      "Verifica que el identificador del seguro enviado en la solicitud sea válido."),
  INSURANCE_DISABLED("Q_9002", HttpStatus.CONFLICT,
      "El seguro asociado al identificador proporcionado se encuentra deshabilitado.",
      "Verifica que el insuranceId enviado corresponda a un seguro activo."),
  EXCEPTION_CREATE("Q_9003", HttpStatus.INTERNAL_SERVER_ERROR,
      "Se produjó un error al realizar la creación de la cotización.",
      "Se produjó un error interno al realizar la creación de la cotización.");

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
