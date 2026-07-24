package hn.ficohsa.msvc_ficohsa_insurance.documentation.controllers;

public final class AuthControllerDoc {

  public static final String TAG_NAME = "Autenticacion";
  public static final String TAG_DESCRIPTION = "Operaciones para iniciar sesion y obtener un token JWT.";

  public static final String VERIFY_SUMMARY = "Verificar credenciales y emitir token JWT";
  public static final String VERIFY_DESCRIPTION = """
      ## Objetivo

      Valida el usuario y la contraseña contra el repositorio de usuarios habilitados.
      Si las credenciales son correctas, genera un token JWT que debe enviarse en
      las peticiones posteriores.

      ## Reglas de negocio

      - El usuario debe existir y estar **habilitado**.
      - La contrasena debe cumplir la politica de complejidad definida en el DTO.
      - Este endpoint es **publico**: no requiere token previo.

      ## Uso del token

      Incluye el token en el encabezado:

      ```http
      Authorization: Bearer <token>
      ```
      """;

  private AuthControllerDoc() {
  }
}
