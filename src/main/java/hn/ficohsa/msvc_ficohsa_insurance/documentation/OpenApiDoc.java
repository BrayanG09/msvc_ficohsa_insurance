package hn.ficohsa.msvc_ficohsa_insurance.documentation;

public final class OpenApiDoc {

  public static final String TITLE = "API de Seguros Ficohsa";
  public static final String VERSION = "1.0.0";
  public static final String CONTACT_NAME = "Ficohsa Seguros";
  public static final String CONTACT_EMAIL = "10brayanalvarez@gmail.com";
  public static final String SECURITY_SCHEME_NAME = "bearerAuth";
  public static final String SECURITY_SCHEME = "bearer";
  public static final String SECURITY_BEARER_FORMAT = "JWT";

  public static final String SECURITY_DESCRIPTION = """
      Autenticacion mediante token JWT.

      1. Invoca el endpoint `POST /auth/verify` con usuario y contrasena.
      2. Copia el valor de `data.token` de la respuesta.
      3. Pulsa **Authorize** e ingresa el token (sin prefijo adicional; Swagger agrega `Bearer`).
      """;

  public static final String DESCRIPTION = """
      ## Microservicio de seguros Ficohsa

      API REST para autenticacion de usuarios, consulta de productos de seguro
      y registro de cotizaciones vehiculares.

      ### Convencion de respuesta

      Todas las respuestas envuelven el resultado en `ResponseDTO`:

      | Campo | Descripcion |
      | --- | --- |
      | `code` | Codigo de negocio |
      | `message` | Mensaje orientado al usuario |                    
      | `description` | Detalle tecnico o contextual |
      | `timestamp` | Fecha y hora de la respuesta |
      | `data` | Cuerpo util (puede ser un arreglo vacio en casos de error, exitoso o no hayan datos) |

      ### Seguridad
      Los endpoints de productos y cotizaciones requieren un JWT valido en el
      encabezado `Authorization: Bearer <token>`.
      """;

  private OpenApiDoc() {
  }
}
