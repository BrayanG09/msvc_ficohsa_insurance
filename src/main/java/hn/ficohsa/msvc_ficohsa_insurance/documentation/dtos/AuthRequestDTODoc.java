package hn.ficohsa.msvc_ficohsa_insurance.documentation.dtos;

public final class AuthRequestDTODoc {

  public static final String DESCRIPTION = "Credenciales para autenticar a un usuario del sistema.";
  public static final String USERNAME = "Nombre de usuario. Maximo 50 caracteres.";
  public static final String PASSWORD = "Contraseña. Minimo 6 caracteres, con mayuscula, minuscula, numero y caracter especial.";

  public static final String USERNAME_EXAMPLE = "brayan.alvarez";
  public static final String PASSWORD_EXAMPLE = "Brayan.10!";

  private AuthRequestDTODoc() {
  }
}
