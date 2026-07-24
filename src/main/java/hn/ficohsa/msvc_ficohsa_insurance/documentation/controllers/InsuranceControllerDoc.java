package hn.ficohsa.msvc_ficohsa_insurance.documentation.controllers;

public final class InsuranceControllerDoc {

  public static final String TAG_NAME = "Productos de seguro";
  public static final String TAG_DESCRIPTION = "Consulta paginada del catalogo de seguros disponibles.";

  public static final String FIND_ALL_SUMMARY = "Listar productos de seguro habilitados";
  public static final String FIND_ALL_DESCRIPTION = """
      ## Objetivo

      Devuelve una pagina de productos de seguro activos, incluyendo su categoria
      y las condiciones vigentes asociadas.

      ## Paginacion

      Acepta los parametros estandar de Spring Data:

      `page` = Numero de pagina (base 0).
      `size` = Cantidad de elementos por pagina.
      `sort` = Criterio de ordenamiento.

      Ejemplo:

      ```http
      GET /products?page=0&size=10&sort=insuranceName,asc
      ```

      ## Contenido de cada producto

      - Identificador y nombre del seguro
      - Descripcion comercial y precio
      - Categoria a la que pertenece
      - Condiciones habilitadas (mapping y condicion activos)

      ## Seguridad

      Requiere autenticacion JWT. Usa el boton **Authorize** de Swagger UI
      con un token obtenido desde `POST /auth/verify`.
      """;

  private InsuranceControllerDoc() {
  }
}
