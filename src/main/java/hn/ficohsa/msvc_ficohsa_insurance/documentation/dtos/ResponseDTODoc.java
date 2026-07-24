package hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos;

public final class ResponseDTODoc {

  public static final String DESCRIPTION = "Envelope estandar de respuesta de la API.";
  public static final String CODE = "Codigo de negocio de la operacion.";
  public static final String MESSAGE = "Mensaje orientado al usuario final.";
  public static final String DESCRIPTION_FIELD = "Descripcion complementaria del resultado.";
  public static final String TIMESTAMP = "Fecha y hora en que se genero la respuesta.";
  public static final String DATA = "Cuerpo util de la respuesta. Puede ser nulo en errores.";

  public static final String CODE_EXAMPLE = "API_200";
  public static final String MESSAGE_EXAMPLE = "Operacion exitosa";
  public static final String DESCRIPTION_EXAMPLE = "La solicitud se proceso correctamente.";
  public static final String TIMESTAMP_EXAMPLE = "2026-07-23T20:30:00";

  private ResponseDTODoc() {
  }
}
