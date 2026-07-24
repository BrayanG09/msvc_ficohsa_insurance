package hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos;

public final class AuthResponseDTODoc {

  public static final String DESCRIPTION = "Respuesta de autenticacion exitosa con el token JWT emitido.";
  public static final String TOKEN = "Token JWT que debe enviarse en el encabezado Authorization de las peticiones protegidas.";
  public static final String TOKEN_EXAMPLE = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiJqcGVyZXoifQ.example";

  private AuthResponseDTODoc() {
  }
}
